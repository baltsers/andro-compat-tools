import os
import os.path
import re
#"/home/zyzhang/androZooLogs/benign-2010"
rootdir = "/home/zyzhang/runlogs_apks2017"
#write the primary result into primaryResultofLog20102016.txt
fo=open('primaryResultofLogbenign-2017-19.txt','w')

#count the total number of all documents
totalDoc = 0
totalApk = 0
succ = 0
fail = 0
for parent, dirnames, filenames in os.walk(rootdir):
   # for dirname in dirnames:
        #print('parent is: ' + parent)
	#fo.write('===============In %s:\n' %dirname)
	#print('dirname is: ' + dirname)
    #first check .logcat file
    for filename in filenames:
	#print('parent is: ' + parent)
	#print('filename is: ' + filename)
	
        #check whether it is .logcat or . monkey
	logcat = filename.find('.logcat')
	monkey = filename.find('.monkey')
	
	#get the full name of document
	fullname=os.path.join(parent,filename)
	#print(fullname)        
	
	if(logcat>0):#.logcat file:
	    totalApk = totalApk + 1
	    #print('NO.%d' %totalApk)
	    #get the name of apk
	    nameoflog=filename[0:logcat]
	    #print(nameoflog)
	    #print(parent)
	    #name of correspounding .monkey file
	    comon=nameoflog+'.monkey'
	    monkeyfull=parent+'/'+comon
	    #print(monkeyfull)

	    #open the .logcat file and check its length
	    fl=open(fullname,'r')
	    ldata=fl.read()
	    count=len(ldata)
	    fl.close()
	    #if len=2, the apk crashed immediately
	    if count==2:
#		print('%s crashed immediately\n' %nameoflog)
		fo.write('%s crashed immediately\n' %nameoflog)
	    else:
		fo.write('%s can be launched, check if there exists errors.\n' %nameoflog)
		#print('%s check more:' %nameoflog)
                for filename in filenames:
		#open correspounding .monkey file, print(monkeyfull)
    		    fm=open(monkeyfull)
		    mdata=fm.read()
		    mlist=mdata.splitlines()
		    listlen=len(mlist)
		#use a int to control break from the loop
		    check=0

		    if(listlen==0):
			#print('%s runs successfully' %nameoflog)
		        fo.write('%s runs successfully\n' %nameoflog)
			check=ckeck+1
			succ=succ+1
		    else:
			#use a sum to control break from the loop
			s=0
		        for i in range(0,listlen):
			    message=mlist[i]
		            crash=message.find('CR')
		            short=message.find('Short')
		            longM=message.find('Long')
			    if(longM < 0):
			        if(short < 0):
				    if(crash < 0):
				        i=i+1
				    else:#crash
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
		
	             #print('%s is checking finished' %nameoflog)
		    if(check==1):
			fo.write('%s is checking finished\n' %nameoflog)
			break     		    
#		print(totalApk)
	totalDoc = totalDoc +1
#	print('the full name of the file is: '+ os.path.join(parent,filename))
print('%d %d %d' %(totalApk, succ, fail))
