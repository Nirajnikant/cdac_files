#!/bin/bash

read -p "Enet a file path" path

if [[ -f $path ]]
then
    echo "$path is a file."
elif [[ -d $path ]]
then
	echo "$path is a directory."
else
	echo "Invalid path"
fi
