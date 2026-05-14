import re
import os

sdk_category=[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27]


#primaryResultofLog2015.txt
#fp=open('/home/zyzhang/primaryResultofLogCheck2015.txt')
fp=open('/home/zyzhang/primaryResultofLog2015.txt')
result=fp.read()
fp.close()


list = result.splitlines()
l=len(list)
fail_name=[]

for i in range(l):
    message=list[i]
    index=message.find(" is checking finished")

    if(index>=0):
        name1=message[:index]
        fail_name.append(name1)



#check sdk version:

fail_name_full=[]
len_fail=len(fail_name)
for i in range(0,len_fail):
    name="/home/hcai/Downloads/AndroZoo/2015/"+fail_name[i]
#    name="/home/hcai/Downloads/VirusShare/2015/"+fail_name[i]
    fail_name_full.append(name)

#cmd = "getanysdk.sh " + fail_name_full[20]
#sdk_minOrtarget = os.system(cmd)


#print("printing SDK finished")



#provide to Dr.Cai
#fa=open('/home/zyzhang/apkname_run_fail_malware-2015.txt','w')
#provide failed running apk name list for Dr.Cai
for i in range(len(fail_name_full)):
    print(fail_name_full[i])
#    fa.write(fail_name_full[i]+'\n')
#fa.close()
#print("list name finished")






