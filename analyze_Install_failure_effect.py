import re
import os

def classify_sdk(array_previous):
    sdklist_new=[]
   #initial sdk classifier
    total=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    api=[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27]
    l_input=len(array_previous)
    for i in range(0,l_input):
	message=array_previous[i]
	error=message.find('ERROR')
	if(error >=0 ):
	    total[0]+=1
        elif(message == '0'):
            total[0]=total[0]+1
        elif(message == '0x1'):
            total[1]=total[1]+1
        elif(message == '0x2'):
            total[2]=total[2]+1
        elif(message == '0x3'):
            total[3]=total[3]+1
     
        elif(message == '0x4'):
            total[4]=total[4]+1
        
        elif(message == '0x5'):
            total[5]=total[5]+1
        elif(message == '0x6'):
            total[6]=total[6]+1
      
        elif(message == '0x7'):
            total[7]=total[7]+1
       
        elif(message == '0x8'):
            total[8]=total[8]+1
       
        elif(message == '0x9'):
            total[9]=total[9]+1
        
        elif(message == '0xa'):
            total[10]=total[10]+1
        
        elif(message == '0xb'):
            total[11]=total[11]+1
       
        elif(message == '0xc'):
            total[12]=total[12]+1
        
        elif(message == '0xd'):
            total[13]=total[13]+1
        
        elif(message == '0xe'):
            total[14]=total[14]+1
        
        elif(message == '0xf'):
            total[15]=total[15]+1
        
        elif(message == '0x10'):
            total[16]=total[16]+1
       
        elif(message == '0x11'):
            total[17]=total[17]+1
        
        elif(message == '0x12'):
            total[18]=total[18]+1
        
        elif(message == '0x13'):
            total[19]=total[19]+1
        
        elif(message == '0x14'):
            total[20]=total[20]+1
             
        elif(message == '0x15'):
            total[21]=total[21]+1
        
        elif(message == '0x16'):
            total[22]=total[22]+1
         
        elif(message == '0x17'):
            total[23]=total[23]+1
        
        elif(message == '0x18'):
            total[24]=total[24]+1
        
        elif(message == '0x19'):
            total[25]=total[25]+1
        
        elif(message == '0x1a'):
            total[26]=total[26]+1
        elif(message == '0x1b'):
            total[27]=total[27]+1
    for i in range(len(total)):
	if(total[i]>0):
	    print("SDK %d, %d" %(api[i],total[i]))
    return(total)



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



fo = open('/home/zyzhang/result201023.txt')
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
fail_uninstall_name=[]
fail_uninstall_effect=[]
for i in range(2,l):
    
    message = list[i]
    message_last = list[i-2]
    already_ins = message.find('.apk already installed or tried so, skipped.')
    suc_mes = message.find('installed successfully')
    fail_mes = message.find('#')
    apk_mes = message.find('====================================== Install INDIVIDUAL APP: ')
    failure = message.find('Failure')
    error = message.find('Error')
    adb = message.find('adb')
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

    if(adb >=0):
#	print(message)
        ft.write(message + '\n')
    elif(failure >= 0):
#	print(message_last)
	if_uninstall = message_last.find('uninstall')
	apkname_full = message_last[:apkname_index]
#	print(apkname_full)
	if(if_uninstall>=0):#the failure is about uninstallation but not about installation
	    fail_uninstall_name.append(apkname_full)
	    fail_uninstall_effect.append(message)
	else:
	    fail_name.append(apkname_full)
	    fail_effect.append(message)
        ft.write(message + '\n')
    elif(error >=0):
#	print(message)
        ft.write(message + '\n')
    
        
ft.close()

################################     PART 1: for each failed installation, check its sdk    ########################
#print(fail_name,fail_effect)

fail_sdk = []
len_fail=len(fail_name)
for i in range(0,len_fail):
    cmd = "getanysdk.sh " + fail_name[i]
    sdk_minOrtarget = os.system(cmd)
    fail_sdk.append(sdk_minOrtarget)
#    print(cmd)
#    print(sdk_minOrtarget)
#    print(fail_name[i],fail_effect[i],fail_sdk[i])
#for each failed installation, use 3 arrays to record its apk name, failed effect, and minimum or target sdk version
effect_order,effect_time=classify_effect(fail_effect)
print(effect_order, effect_time)









#################################    PART 2: do the classification of failed effects    ############################ 

print('%d + %d  = %d' %(suc_tot,fail_tot, total))
#l1=len(fail_name)
#l2=len(fail_effect)
#print(l1,l2)
#open the temporary store document, gather useful information first and classify failed effects
fp = open('/home/zyzhang/tem_for_fail_mes.txt')
result_failmes = fp.read()
fp.close()

list_failmes = result_failmes.splitlines()
l_new = len(list_failmes)
Reasons = []
no_space = 0
no_device = 0
usage_tot = 0
for i in range(0,l_new):
    message_fail = list_failmes[i]
    failure_reason = message_fail.find('.apk: ')
    usage = message_fail.find('adb: usage: install requires an argument')    
    adb = message_fail.find('adb: ')
    error = message_fail.find('Error')
    Failure = message_fail.find('Failure')
    space = message_fail.find('No space')
    device = message_fail.find('failed to get feature set: device ')
    if(failure_reason >= 0):
        reason = message_fail[failure_reason+6:]
        Reasons.append(reason)
    elif(error >=0):
        #print(message)
        Reasons.append(message_fail)
    elif(Failure >=0):
        #print(message)
        Reasons.append(message_fail)
    elif(space >= 0):
	no_space = no_space + 1
	#Reasons.append('No Space')
    elif(device >= 0):
	no_device = no_device + 1
    if(usage >= 0):
	usage_tot = usage_tot + 1

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






print('In % d  apps :      successful: %d        failed: %d '%(total, suc_tot, fail_tot))
print('In these %d failed installment(s), there exists %d kinds of failures' %(fail_tot,l_effect))
for i in range(0,l_effect):
    print('Effect: %s          Times: %d'%(effect_name[i],effect_time[i]))



#print information about failed uninstallation
#if(fail_unin > 0):
#    print('%d apk(s) occur failed uninstallation, the reasons are:' %fail_unin)
#    for i in range(0,fail_unin):
#	print(fail_uninstall_name[i],fail_uninstall_effect[i])
    
#print specific failed reasons
if(no_device>0):
    print('There are %d apk which intallment failure is beacuse of no device' %no_device)
if(no_space>0):
    print('There are %d apk which intallment failure is beacuse of limited space' %no_space)
if(usage_tot > 0):
    print('The message <adb: usage: install requires an argument> occurs %d times' %usage_tot)



#for i in range(l_effect):
 #   if(effect_time[i]>0):
#	print('Effect: %s          Times: %d'%(effect_name[i],effect_time[i]))
 #   else:
#	for j in effect_name[i]:
#	    if j not in effect_again_name:	
#		effect_again_name.append(effect_name[i])
#		effect_again_time[i]+=effect_time[i]
#l_new=len(effect_again_name)
#for i in range(0,l_new):

 #   print('Effect: %s          Times: %d'%(effect_again_name[i],effect_again_time[i]))
