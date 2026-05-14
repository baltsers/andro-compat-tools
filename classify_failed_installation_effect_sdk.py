import re
import os
import xlwt

sdk_category=[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27]
#['0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27']

def classify_sdk():
    
    fp=open('res.txt')
    result=fp.read()
    fp.close()

    list = result.splitlines()
    l=len(list)
    sdk=[]
    
    #initial sdk classifier
    sdk_classify=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
#    api=[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27]
    api=['0','0x1','0x2','0x3','0x4','0x5','0x6','0x7','0x8','0x9','0xa','0xb','0xc','0xd','0xe','0xf','0x10','0x11','0x12','0x13','0x14','0x15','0x16','0x17','0x18','0x19','0x1a','0x1b']
    
    for i in range(l):
        message=list[i]
	e=message.find("ERROR")
	if(e>=0):
	    sdk_classify[0]+=1
	    sdk.append(0)
	else:
            for j in range(len(api)):
                if(message==api[j]):
                    sdk_classify[j]+=1
		    sdk.append(j)
#    print(sdk)
    return sdk_classify,sdk



def classify_effect(Reasons):
    #use 2 arrays to record total effect catologies names and occuring times:
    effect_name = []
    effect_time = []

    for i in Reasons:
        if i not in effect_name:
            effect_name.append(i)

    l_reasons=len(Reasons)
    l_effect=len(effect_name)

    for i in range(0,l_effect):
        effect_time.append(Reasons.count(effect_name[i]))
    return effect_name, effect_time

def testXlwt(effect,sdk,content):
    book = xlwt.Workbook()
    sheet1 =book.add_sheet('list apk amount')
    sheet2 =book.add_sheet('list apk name')
    #set style
    style = xlwt.XFStyle()
    al=xlwt.Alignment()
    al.horz=0x02
    al.vert=0x01
    style.alignment = al
    
    #
    first_col=sheet1.col(0)
    first_col.width=256*50

    
    l_e=len(effect)
    l_s=len(sdk)
    sheet1.write_merge(0,1,0,0,'EFFECT',style)
    sheet1.write_merge(0,0,1,l_s,'SDK',style)
    for i in range(l_e):
        sheet1.write(i+2,0,effect[i])
    for i in range(l_s):
        sheet1.write(1,i+1,sdk[i],style)
    	
    for i in range(l_e):
        for j in range(l_s):
            sheet1.write(i+2,j+1,content[i][j],style)
	

    book.save('2010.xls')


def sum(time):
    l_sum=len(time)
    sum_time=0
    for i in range(l_sum):
	sum_time+=time[i]
    return sum_time


#catch useful message about successful installations, failed installations
#intial result about failed installation aslo contain failed uninstallations

fo = open('/home/zyzhang/tryinstall_b2017_22.txt')
result = fo.read()
fo.close()

list = result.splitlines()
l = len(list)

ft = open('/home/zyzhang/tem_for_fail_mes.txt','w')

#count how many apks there are
total = 0
suc_tot = 0
fail_tot = 0
fail_unin = 0

#create two array to store failed apks' name and effect
fail_name=[]
fail_effect=[]

#create two array to store failed uninstallation apks' name and effect
fail_uninstall_name=[]
fail_uninstall_effect=[]

#traverse all document,gather useful messages about failure and record them into a new document
for i in range(2,l):
    
    message = list[i]
    message_last = list[i-2]
    already_ins = message.find('.apk already installed or tried so, skipped.')
    suc_mes = message.find('installed successfully')
    fail_mes = message.find('#')
    apk_mes = message.find('====================================== Install INDIVIDUAL APP: ')
    failure = message.find('Failure')
    fail_adb = message.find('adb: failed to install ')
    F=message.find('fail')
    uninstalling=message.find('uninstalling')    
    if(apk_mes >= 0):
        total = total + 1

    if(uninstalling>=0):
	fail_unin += 1
	
    if(already_ins >= 0):
	suc_tot += 1
	total += 1
    if(suc_mes > 0): #for the successful app, count and ignore it
        suc_tot = suc_tot + 1
        
    elif(fail_mes > 0): #for the failed one, count it first and then copy them into a new txt document
        fail_tot = fail_tot + 1
	

#for the failed installment, catch the failure message
    apkname_index=message_last.find(': 1 file pushed.')

    if(fail_adb >=0):
   #     ft.write(message + '\n')
	if(failure<0):
	    endindex=message.find(".apk")
	    apkname_full=message[23:endindex+4]
	    fail_name.append(apkname_full)
	    fail_effect.append("No messsage")
    if(failure >= 0):
	if_uninstall = message_last.find('uninstall')
	apkname_full = message_last[:apkname_index]

	if(if_uninstall>=0):#the failure is about uninstallation but not about installation
	    fail_uninstall_name.append(apkname_full)
	    fail_uninstall_effect.append(message)
	else:
	    endindex=message.find(".apk:")
            apkname_full=message[23:endindex+4]
	    fail_name.append(apkname_full)
	    fail_effect.append(message)
        ft.write(message + '\n')
  
   
        
ft.close()

#for i in range(len(fail_effect)):
#    print(i, fail_effect[i])

################################     PART 1: for each failed installation, check its sdk    ########################
#print(fail_name)
#remind:
#fail_name[] and fail_effect[] record failed installations' name and effect
#fsdk = open('/home/zyzhang/res.txt','w')

maxSDK_version=[]
maxSDK_name=[]
#fail_sdk_mes = []
len_fail=len(fail_name)
for i in range(0,len_fail):
    cmd = "getminsdk.sh " + fail_name[i]
    sdk_minOrtarget = os.system(cmd)

    cmd2="getminsdk.sh " + fail_name[i]
    sdk_max = os.system(cmd2)
    if(sdk_max<19):
	maxSDK_version.append(sdk_max)
	maxSDK_name.append(fail_name[i])


#    print(sdk_minOrtarget)
#    fsdk.write(sdk_minOrtarget)
#    fail_sdk_mes.append(sdk_minOrtarget)
print("printing SDK finished")
#fsdk.close()

sdk_classify,fail_sdk=classify_sdk()

#for i in range(len(sdk_classify)):
#    if(sdk_classify[i]!=0):
#	print(i)
#print(len(fail_name),len(fail_effect),len(fail_sdk))

#for each failed installation, use 3 arrays to record its apk name, failed effect, and minimum or target sdk version
#these 3 arrays are: fail_name[i],fail_effect[i],fail_sdk[i]







#################################    PART 2: do the classification of failed effects    ############################ 

#open the temporary store document, gather useful information first and classify failed effects



#if effect name is fixed with wrong info
l_tem=len(fail_name)
fail_new_effect=fail_effect
for i in range(l_tem):
    effect=fail_effect[i]
    
    ABI=effect.find("Failure [INSTALL_FAILED_NO_MATCHING_ABIS")
    exeption=effect.find("Failure [INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION")
    bad_package=effect.find("Failure [INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME")    
    library=effect.find("Failure [INSTALL_FAILED_MISSING_SHARED_LIBRARY")
    old_sdk=effect.find("Failure [INSTALL_FAILED_OLDER_SDK")
    userid=effect.find("Failure [INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID")
    manifest=effect.find("Failure [INSTALL_PARSE_FAILED_MANIFEST_MALFORMED")
    certificate=effect.find("Failure [INSTALL_PARSE_FAILED_NO_CERTIFICATES")
    duplicate=effect.find("Failure [INSTALL_FAILED_DUPLICATE_PERMISSION")
    version=effect.find("INSTALL_FAILED_VERSION_DOWNGRADE")

    if(ABI>=0):
        fail_effect[i]="Failure [INSTALL_FAILED_NO_MATCHING_ABIS]"
    if(exeption>=0):
        fail_effect[i]="Failure [INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION]"
    if(bad_package>=0):
	fail_effect[i]="Failure [INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME]" 
    if(library>=0):
	fail_effect[i]="Failure [INSTALL_FAILED_MISSING_SHARED_LIBRARY]"
    if(old_sdk>=0):
	fail_effect[i]="Failure [INSTALL_FAILED_OLDER_SDK]"
    if(userid>=0):
	fail_effect[i]="Failure [INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID]"
    if(manifest>=0):
	fail_effect[i]="Failure [INSTALL_PARSE_FAILED_MANIFEST_MALFORMED]"
    if(certificate>=0):
	fail_effect[i]="Failure [INSTALL_PARSE_FAILED_NO_CERTIFICATES]"
    if(duplicate>=0):
	fail_effect[i]="Failure [INSTALL_FAILED_DUPLICATE_PERMISSION]"
    if(version>=0):
	fail_effect[i]="Failure [INSTALL_FAILED_VERSION_DOWNGRADE]"



    if(fail_new_effect[i]!=fail_effect[i]):
        print(fail_effect[i]+"\n")

effect_order,effect_time=classify_effect(fail_effect)
#print(effect_order, effect_time)

#check specific failure reason:
fp = open('/home/zyzhang/tem_for_fail_mes.txt')
result_failmes = fp.read()
fp.close()

list_failmes = result_failmes.splitlines()
l_new = len(list_failmes)
no_space = 0
no_device = 0
usage_tot = 0
for i in range(0,l_new):
    message_fail = list_failmes[i]
    usage = message_fail.find('adb: usage: install requires an argument')    
    space = message_fail.find('No space')
    device = message_fail.find('failed to get feature set: device ')
    if(space >= 0):
	no_space = no_space + 1
    elif(device >= 0):
	no_device = no_device + 1
    if(usage >= 0):
	usage_tot = usage_tot + 1



#################################    PART 3: remind useful information
#for all failed installation:
	#effect_order : the whole kinds of effect categories
	#effect_time : corresponding occured times
	#sdk_category : the whole kinds of sdk versions

#for each failure:
	#fail_name: the apk's name
	#fail_effect: the apk's failed effect
	#fail_sdk: the apk's target or minimum sdk version
	
total_category_effect=len(effect_order)
total_fail=len(fail_name)
total_category_sdk=len(sdk_category)


#print(len(fail_name),len(fail_sdk))

#################################    PART 4: classify

#use a 2d array to record distribution:

content_of_effect = [[[] for col in range(total_category_sdk)] for row in range(total_category_effect)]
amount_of_effect = [[0 for col in range(total_category_sdk)] for row in range(total_category_effect)]

for i in range(total_fail):
    fullname=fail_name[i]
#    print(fullname)
    sdk=fail_sdk[i]
    effect=fail_effect[i]
#    print(sdk,effect) 
   
    for j in range(total_category_effect):
        if(effect == effect_order[j]):
        
            for k in range(total_category_sdk):
                if(sdk == sdk_category[k]):
                    content_of_effect[j][k].append(fullname)
		    amount_of_effect[j][k] += 1
                    
#print(content_of_effect)
#======






#=============================================================================
##################################    PART 5: the final step: output all result

#5.1 output initial result

print('In % d  apps :      successful: %d        failed: %d '%(total, suc_tot, fail_tot))
print('In these %d failed installment(s), there exists %d kinds of failures' %(fail_tot,total_category_effect))
#for i in range(0,total_category_effect):
#    print('Effect: %s          Times: %d'%(effect_order[i],effect_time[i]))


#5.2 output classification and save it into a document:
#fc=open('/home/zyzhang/malware_2015_bonus_23_insta_effect_sdk.txt','w')
fc=open('/home/zyzhang/benign_2017_22_insta_effect_sdk.txt','w')

sum_fail=sum(effect_time)
bias=fail_tot-sum_fail
print("After counting adk version, the total failed number is %d" %sum_fail)
print("There are %s apks cannot be open/ do not have failure messages\n" %bias)


for i in range(total_category_effect):
    print("< %d >:   Effect: %s           Times:%d" %(i+1,effect_order[i],effect_time[i]))
    fc.write("Effect: %s  Times:%d \n" %(effect_order[i],effect_time[i]))
    for j in range(total_category_sdk):
        if(content_of_effect[i][j] != []):
            fc.write("	    -- SDK %s :   %s    \n" %(sdk_category[j], content_of_effect[i][j]))
	    print("   	 -- SDK %s :   %s" %(sdk_category[j], amount_of_effect[i][j]))



fc.close()
#5.3 output information about failed uninstallation
            
#if(fail_unin > 0):
#    print('%d apk(s) occur failed uninstallation, the reasons are:' %fail_unin)
#    for i in range(0,fail_unin):
#	print(fail_uninstall_name[i],fail_uninstall_effect[i])


   
#5.4 Additional: output several specific failed reasons
if(no_device>0):
    print('There are %d apk which intallment failure is beacuse of no device' %no_device)
if(no_space>0):
    print('There are %d apk which intallment failure is beacuse of limited space' %no_space)
if(usage_tot > 0):
    print('The message <adb: usage: install requires an argument> occurs %d times' %usage_tot)
#5.5 Save distribution between effect information and sdk version into .xls document, named as malware_2010_23.xls
#testXlwt(effect_order,sdk_category,content_of_effect)



#if effect name is fixed with wrong info
l_tem=len(fail_name)
fail_new_effect=fail_effect
for i in range(l_tem):
    effect=fail_effect[i]
    ABI=effect.find("ABI")
    exeption=effect.find("Failure [INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION")
    if(ABI>=0):
	fail_new_effect[i]="Failure [INSTALL_FAILED_NO_MATCHING_ABIS]"
    if(exeption>=0):
	fail_new_effect[i]="Failure [INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION"
    













