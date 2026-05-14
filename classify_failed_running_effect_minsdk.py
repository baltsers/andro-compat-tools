import os
import os.path
import re

sdk_category=[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27]
rootdir = "/home/zyzhang/otheremulators/androZooLogs-Nexus-One-27-2/benign-2014"
#rootdir = "/home/zyzhang/androZooLogs/benign-2010"
#define several functions:
def classify_effect(effect_name,effect_time):
    occured_effect_name=[]
    occured_effect_time=[]
    l=len(effect_name)
    for i in range(l):
        if(effect_time[i]>0):
            occured_effect_name.append(effect_name[i])
            occured_effect_time.append(effect_time[i])


    return occured_effect_name,occured_effect_time


def classify_sdk():

    fp=open('res_run.txt')
    result=fp.read()
    fp.close()

    list = result.splitlines()
    l=len(list)
    sdk=[]

    #initial sdk classifier
    sdk_classify=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    api=['0','0x1','0x2','0x3','0x4','0x5','0x6','0x7','0x8','0x9','0xa','0xb','0xc','0xd','0xe','0xf','0x10','0x11','0x12','0x13','0x14','0x15','0x16','0x17','0x18','0x19','0x1a','0x1b']

    for i in range(l):
        message=list[i]
	#index = message.find("targetSdkVersion")
	index = message.find("minSdkVersion")
        for j in range(len(api)):
            if(message==api[j]):
                sdk_classify[j]+=1
                sdk.append(j+1)
	    elif(index>=0):
		sdk_classify[17]+=1
		sdk.append(18)

    return sdk_classify,sdk

#============================================================================
#write the primary result into primaryResultofLog20102016.txt
fo=open('primaryResultofLogbenign-2014-27.txt','w')

#count the total number of all documents
totalDoc = 0
totalApk = 0
succ = 0
fail = 0
for parent, dirnames, filenames in os.walk(rootdir):       
    #first check .logcat file
    for filename in filenames:
        
        #check whether it is .logcat or . monkey
	logcat = filename.find('.logcat')
	monkey = filename.find('.monkey')
	
	#get the full name of document
	fullname=os.path.join(parent,filename)
	
	#.logcat file:
	if(logcat>0):
	    totalApk = totalApk + 1
	
	    #get the name of apk
	    nameoflog=filename[0:logcat]
	    
	    #name of correspounding .monkey file
	    comon=nameoflog+'.monkey'
	    monkeyfull=parent+'/'+comon

	    #open the .logcat file and check its length
	    fl=open(fullname,'r')
	    ldata=fl.read()
	    count=len(ldata)
	    fl.close()
	    
	    #if len=2, the apk crashed immediately
	    if count==2:
		fo.write('%s crashed immediately\n' %nameoflog)
	    else:
		fo.write('%s can be launched, check if there exists errors.\n' %nameoflog)
                for filename in filenames:
		#open correspounding .monkey file, print(monkeyfull)
    		    fm=open(monkeyfull)
		    mdata=fm.read()
		    mlist=mdata.splitlines()
		    listlen=len(mlist)

                    #use a int to control break from the loop
		    check=0

		    if(listlen==0):
		        fo.write('error: no message! \n')
			check=check+1
		    else:
			#use a sum to control break from the loop
			s=0
		        for i in range(0,listlen):
			    message=mlist[i]
		            crash=message.find('CRASH')
		            short=message.find('Short')
		            longM=message.find('Long')

                            tem=longM+short+crash
                            if(tem==0):
                                fo.write('%s runs successfully\n' %nameoflog)
		            
			    if(longM < 0):
			        if(short < 0):
				    if(crash < 0):
				        i=i+1
				    else:#crash
					print(mlist[i])
				        fo.write(mlist[i]+'\n')
				        i=i+1
					s=s+1
					fail=fail+1
			        else:#short msg
				    fo.write(mlist[i]+'\n')
				    i=i+1
				    s=s+1
			    else:#long msg
			        fo.write(mlist[i]+'\n')
			        i=i+1
    				s=s+1
			    if(s==3):
				break
			check=check+1
		
		    if(check==1):
			fo.write('%s is checking finished\n' %nameoflog)
			break     		    
	totalDoc = totalDoc +1

fo.close()
succ_test=totalApk-fail
print('total:%d    successful:%d    failed:%d' %(totalApk,succ_test,fail))
#============================================================================
fp=open('primaryResultofLogbenign-2014-27.txt')
result=fp.read()
fp.close()

list = result.splitlines()
l=len(list)

#count how many apks there are
total = 0
total_success=0
total_fail=0

#use long msg to locate the error
effect_name=['Native Crash','Verify error','Illegal monitor','No Class','Security','Null pointer','unatisfied link','lang.error','IO exception','Activity not found','OTHERS']
effect_time=[0,0,0,0,0,0,0,0,0,0,0]
l_effect_category=len(effect_name)

#create two array to record failed apk's name and effect
fail_name=[]
fail_effect=[]

for i in range(l-1):
    
    message=list[i]
    message_next=list[i]

    # 1. count successful running apks
    apk_begincheck_index=message.find('.apk can be launched')
    apk_finishcheck_index=message_next.find('checking finished')
    
    if(apk_begincheck_index>=0):
        total+=1
        apk_name=message[:apk_begincheck_index+4]
    if(apk_finishcheck_index>=0):
        total_success+=1

      
    # 2. check and gather failure effects
    native=message.find('Native')
    verify=message.find('VerifyError')
    illegal=message.find('IllegalMonitorStateException')
    NoClass=message.find('NoClassDefFoundError')
    Security=message.find('SecurityException')
    NullPointer=message.find('NullPointerException')
    Unsatisfied=message.find('UnsatisfiedLinkError')
    langerror=message.find('lang.Error')
    IOException=message.find('IOException')
    Activity=message.find('ActivityNotFoundException')   

    pointer=[native,verify,illegal,NoClass,Security,NullPointer,Unsatisfied,langerror,IOException,Activity]

    short_mes_index=message.find('//Short Msg:')
    longM=message.find('Long Msg:')
    for j in range(l_effect_category-1):
        if(longM<0):
            i=i+1
        elif(pointer[j]>=0):
            effect_time[j]+=1
            total_fail+=1
            namecatch=list[i-3]
            fullname_index=namecatch.find(' can be launched')
            fullname_name=namecatch[:fullname_index]
            fail_name.append(fullname_name)
            fail_effect.append(effect_name[j])

#simplify effect:
effect_occured_name,effect_occured_time=classify_effect(effect_name,effect_time)
total_category_effect=len(effect_occured_name)
print(total,total_success,total_fail)


#check sdk version:
fail_name_full=[]
len_fail=len(fail_name)
for i in range(0,len_fail):
    name="/home/hcai/Downloads/AndroZoo/benign-2014/"+fail_name[i]
#    name="/home/hcai/Downloads/VirusShare/2016/"+fail_name[i]
#    name="/home/zyzhang/otheremulators/androZooLogs-Nexus-One-26-2/benign-2011"+fail_name[i]
#    name=rootdir+fail_name[i]
    fail_name_full.append(name)
    cmd = "getminsdk.sh " + name
    sdk_minOrtarget = os.system(cmd)

print("printing SDK finished")

sdk_classify,fail_sdk=classify_sdk()
total_category_sdk=len(sdk_category)

#print(sdk_classify)
#print(fail_sdk)

#remind useful information:
#for all fail running:
            #effect_name : the whole kinds of effect categories
            #effect_time, corresponding orrcues times
            #sdk_catetory: the whole kinds of sdk versions
#for each failure:
            #fail_name: the apk's name
            #fail_effect: the apk's failed effect
            #failsdk:the apk's target or minimum sdk versionothers
            
#total_category_effect:total numbers of categories of effects occers
#total_category_sdk: total numbers of categories of sdk occers
#total_fail: amount of failures


#########################3
          
content_of_effect = [[[] for col in range(total_category_sdk)] for row in range(total_category_effect)]
amount_of_effect = [[0 for col in range(total_category_sdk)] for row in range(total_category_effect)]

print(len(fail_name),total_fail,len(fail_sdk))


#for i in range(len(sdk_classify)):
for i in range(total_fail):
    name=fail_name[i]
    sdk=fail_sdk[i]
    effect=fail_effect[i] 

    for j in range(total_category_effect):
        if(effect == effect_occured_name[j]):

            for k in range(total_category_sdk):
                if(sdk == sdk_category[k]):
                    #content_of_effect[j][k].append(name)
                    amount_of_effect[j][k] +=1 


print("Total = %d   Successful = %d   Failed = %d" %(total,total_success,total_fail))
#fc=open('/home/zyzhang/malware_2010_23_install_effect_sdk.txt','w')
fc=open('/home/zyzhang/benign_2014_27_run_effect_sdk.txt','w')
for i in range(total_category_effect):
    print("< %d >:   Effect: %s           Times:%d" %(i+1,effect_occured_name[i],effect_time[i]))
    fc.write("Effect: %s  Times:%d \n" %(effect_occured_name[i],effect_time[i]))
    for j in range(total_category_sdk):
        if(amount_of_effect[i][j] != 0):
            fc.write("      -- SDK %s :   %s    \n" %(sdk_category[j], content_of_effect[i][j]))
            print("      -- SDK %s :   %s" %(sdk_category[j], amount_of_effect[i][j]))



fc.close()
fr=open('/home/zyzhang/res_run.txt')
result_r=fr.read()
fr.close()
list_r = result_r.splitlines()
l_r=len(list_r)

total_zero=0
total_error=0
for i in range(l_r):
    message_r=list_r[i]
    E=message_r.find('ERROR')
    if(E>=0):
	total_error+=1
    if(message_r=='0'):
	total_zero+=1

print("%d apk can not be open, %d apk's sdk is 0"%(total_error,total_zero))














