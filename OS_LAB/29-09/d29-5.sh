#!/bin/bash

read -p "Enter first no. " a
read -p "Enter second no. " b

echo -e "Choose a operation to perform \n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division"
read o

case $o in
	1|Addition|Add|add)
		let "add = $a + $b"
		echo $add
		;;
	2|Subtraction)
		let "sub = $a - $b"
		echo $sub
		;;
	3|Multiply|multiply)
		let "mul = $a * $b"
		echo $mul
		;;
	4|Divide|divide|division)
		let "div = $a / $b"
		echo $div
		;;
	*)
		echo "Invalid operation"
		;;
esac
