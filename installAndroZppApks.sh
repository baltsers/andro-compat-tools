#!/bin/bash
#tmv=${1:-"600"}

avdname=${1:-"Nexus-One-25"}
port=${2:-"5554"}
tmv=${3:-"300"}
did="emulator-$port"


timeout() {

    time=$1

    # start the command in a subshell to avoid problem with pipes
    command="/bin/sh -c \"$2\""

    expect -c "set echo \"-noecho\"; set timeout $time; spawn -noecho $command; expect timeout { exit 1 } eof { exit 0 }"    

    if [ $? = 1 ] ; then
        echo "Timeout after ${time} seconds"
    fi

}
tryInstall()
{
    cate=$1

    srcdir=/home/zyzhang/AndroZoo/$cate
    finaldir=$srcdir

    #> list.alreadytriedinstall.$cate

    k=1

    setupEmuSafe.sh $avdname $port
    pidemu=`ps axf | grep -v "grep" | grep "$avd -scale .3 -no-boot-anim -no-window -port $port" | awk '{print $1}'`

	for fnapk in $finaldir/*.apk;
	do
		if [ `grep -a -c ${fnapk##*/} list.alreadytriedinstall.$cate` -ge 1 ];then
			echo "$fnapk already installed or tried so, skipped."
			continue
		fi

		tgtp=`~/bin/getpackage.sh $fnapk | awk '{print $2}'`


		adb -s $did shell pm list packages -3 | cut -d':' -f2 | tr '\r' ' ' | xargs -r -n1 -t adb uninstall
		adb -s $did shell "rm -rf /data/app/*" 1>/dev/null 2>&1
		#rm -rf /home/zyzhang/.android/avd/${avdname}.avd/userdata*
		#rm -rf /home/zyzhang/.android/avd/${avdname}.avd/cache*
		#rm -rf /home/zyzhang/.android/avd/${avdname}.avd/data
		#rm -rf /home/zyzhang/.android/avd/${avdname}.avd/snapshots
		
		echo
		echo "====================================== Install INDIVIDUAL APP: ${fnapk##*/} ==========================="

		ret=`~/bin/apkinstall $fnapk $did`
		n1=`echo $ret | grep -a -c "Success"`
		if [ $n1 -lt 1 ];then 
		    echo "installing $fnapk failed. Skipping it"
		    echo "$ret  # "
		    adb -s $did shell "pm uninstall $tgtp" 1>/dev/null 2>&1
		    adb -s $did shell "rm -rf /data/app/${tgtp}*" 1>/dev/null 2>&1
		    continue
		fi
		
		echo "$fnapk installed successfully; now uninstall it"
		ret=`~/bin/apkuninstall $fnapk $did`
		n1=`echo $ret | grep -a -c "Success"`


		if [ $n1 -lt 1 ];then 
		    echo "uninstalling $fnapk failed. Skipping it"
		    echo "$ret"
		    adb -s $did shell "pm uninstall $tgtp" 1>/dev/null 2>&1
		    adb -s $did shell "rm -rf /data/app/${tgtp}*" 1>/dev/null 2>&1
		    continue
		fi
		adb -s $did shell "pm uninstall $tgtp" 1>/dev/null 2>&1
		adb -s $did shell "rm -rf /data/app/${tgtp}*" 1>/dev/null 2>&1
		echo "$fnapk unnstalled successfully"
		echo

		echo "${fnapk##*/}" >> list.alreadytriedinstall.$cate
	done
	kill -9 $pidemu

        pidavd=`ps axf | grep -v grep | grep "no-boot-anim -no-window -port $port" | awk '{print $1}'`
	kill -9 $pidavd
	
	rm -rf /tmp/android-zyzhang/*
}

s=0

cats=""
while read cate;
do
    cats="$cats""$cate""    "
done < ./cates20102017.txt

for cate in $cats
#for cate in benign-2011
    do
        c=0
        echo "================================="
        echo "=================================try installing category $cate"
        echo "================================="
        echo
        echo

        tryInstall $cate
        rm -rf /tmp/android-zyzhang/*
    done
exit 0

