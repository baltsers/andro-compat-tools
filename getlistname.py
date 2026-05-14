import os
import os.path
import re

sdk_category=[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27]
sdk_output=0
def file_name(file_dir):   
    L=[]   
    for root, dirs, files in os.walk(file_dir):  
        for file in files:  
            if os.path.splitext(file)[1] == '.apk':  
                L.append(os.path.join(root, file))  
    return L 

def classify_sdk(sdk_input):
    #initial sdk classifier
    #sdk_classify=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    global sdk_output    
    api=['0','0x1','0x2','0x3','0x4','0x5','0x6','0x7','0x8','0x9','0xa','0xb','0xc','0xd','0xe','0xf','0x10','0x11','0x12','0x13','0x14','0x15','0x16','0x17','0x18','0x19','0x1a','0x1b']
    
    fp=open('res.txt')
    result=fp.read()
    fp.close()
    list = result.splitlines()

    for i in range(len(list)):
        message=list[i]
        e=message.find("ERROR")
        if(e<0):
           
            for j in range(len(api)):
                if(message==api[j]):
                    sdk_output=sdk_category[j]
    return sdk_output


#===========================================================

name=file_name("/home/zyzhang/apks2017")
fa=open("/home/zyzhang/name.txt","w")
for i in range(len(name)):
    fa.write(name[i]+"\n")
fa.close()

max_name=[]
max_version=[]
max_old=[]
fb=open("/home/zyzhang/2010maxsdk","w")
for i in range(len(name)):
    cmd="getmaxsdk.sh "+name[i]
    sdk_max=os.system(cmd)
    fb.write(str(sdk_max))
    max_old.append(sdk_max)
    maxsdk=classify_sdk(sdk_max)

    if(maxsdk>18):	
	max_version.append(maxsdk)
	max_name.append(name[i])
fb.close()















