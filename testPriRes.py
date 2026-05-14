import re

fp=open('/home/zyzhang/primaryResultofLogbenign-2016.txt')
result=fp.read()
fp.close()



list = result.splitlines()
l=len(list)
#count how many apks there are
total = 0
for i in range(0, l):
    message=list[i]

    finish=message.find('finished')
    if(finish<0):
        i=i+1
    else:
        total=total+1
        i=i+1
        
#use long msg to locate the error
totnative=0
totveri=0
totille=0
totnoclass=0
totsecu=0
totnull=0
totunsa=0
totlanerr=0
totio=0
totact=0


for i in range(0, l):
    
    message=list[i]
    
    native=message.find('Native')
    verifyError=message.find('VerifyError')
    illegalMonitorStateException=message.find('IllegalMonitorStateException')
    NoClassDefFoundError=message.find('NoClassDefFoundError')
    SecurityException=message.find('SecurityException')
    NullPointerException=message.find('NullPointerException')
    UnsatisfiedLinkError=message.find('UnsatisfiedLinkError')
    langerror=message.find('lang.Error')
    IOException=message.find('IOException')
    ActivityNotFoundException=message.find('ActivityNotFoundException')




    longM=message.find('Long Msg:')
    
    if(longM < 0):
        i=i+1
    elif(native>0): #native crash
        totnative=totnative+1
    elif(verifyError>0):#verifyError
        totveri=totveri+1
    elif(illegalMonitorStateException>0):#illegalMonitorStateException
        totille=totille+1
    elif(NoClassDefFoundError>0): #NoClassDefFoundError
        totnoclass=totnoclass+1
    elif(SecurityException>0):
        totsecu=totsecu+1
    elif(NullPointerException>0):#NullPointerException
        totnull=totnull+1
    elif(UnsatisfiedLinkError>0):#UnsatisfiedLinkError
        totunsa=totunsa+1
    elif(langerror>0):#method does not exist
        totlanerr=totlanerr+1
    elif(IOException>0):#IOException
	totio=totio+1
    elif(ActivityNotFoundException>0):#ActivityNotFoundException
	totact=totact+1
        
suc=total-totnative-totveri-totille-totnoclass-totsecu-totnull-totunsa-totlanerr-totio-totact
others=0
fail=total-suc
print('total: %d    suc: %d    fail: %d' %(total, suc, fail))
print('In the  %d crashed apks:\n native crash: %d\n Verify Error: %d\n illegal Monitor State Exception: %d\n No Class: %d\n Security: %d\n Null pointer: %d\n unsatidfied link: %d\n lang.error: %d\n IO exception: %d\n Activity not found: %d\n others: %d\n'%(fail, totnative, totveri, totille, totnoclass, totsecu, totnull,totunsa, totlanerr, totio, totact, others))


