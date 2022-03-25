#!/bin/bash

read -p "Enter a directory name : " dir

if [[ -d $dir ]]
then
	ls -p | grep -v /
else
	echo "Enter a valid file path"
fi
