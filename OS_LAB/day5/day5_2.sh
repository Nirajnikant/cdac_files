#!/bin/bash

while read line
do 
	shell=$(cat /etc | grep "$line" | stat -c "%a %n" "/etc/$line")
	echo "$line -----> $shell"
done < list.txt
