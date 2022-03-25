#!/bin/bash

var=$(ls /home)
for usr in $var
do
	info_user=$(cat /etc/passwd | grep "$usr" | awk -F':' '{print $7}')
	echo "$usr ---->  $info_user"
done
