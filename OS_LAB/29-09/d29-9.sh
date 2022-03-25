#!/bin/bash

read -p "Enter first no.  " a
read -p "Enter second no. " b
read -p "Enter third no.  " c

if [[ $a > $b ]]
then
	if [[ $a > $c ]]
	then
		echo "$a is the greatest"
	else
		echo "$c is the greatest"
	fi
else
	if [[ $b > $c ]]
        then
                echo "$b is the greatest"
        else 
                echo "$c is the greatest"
        fi
fi
