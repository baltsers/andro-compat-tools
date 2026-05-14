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





#catch useful message about successful installations, failed installations
#intial result about failed installation aslo contain failed uninstallations

fo = open('/home/zyzhang/b2011.txt')
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

   # if(adb >=0):
   #     ft.write(message + '\n')
    if(failure >= 0):
	if_uninstall = message_last.find('uninstall')
	apkname_full = message_last[:apkname_index]

	if(if_uninstall>=0):#the failure is about uninstallation but not about installation
	    fail_uninstall_name.append(apkname_full)
	    fail_uninstall_effect.append(message)
	else:
	    fail_name.append(apkname_full)
	    fail_effect.append(message)
        ft.write(message + '\n')
  #  elif(error >=0):
  #      ft.write(message + '\n')
    
        
ft.close()

#print(fail_effect)
fa=open('/home/zyzhang/benign2011_insufficient_storage_apklist.txt','w')
for i in range(len(fail_effect)):
    if(fail_effect[i] == "Failure [INSTALL_FAILED_INSUFFICIENT_STORAGE]"):
        print(fail_name[i])
	fa.write(fail_name[i]+"\n")
fa.close()
