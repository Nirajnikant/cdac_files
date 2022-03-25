#!/bin/bash

os=$(uname -o)
echo "Operating System ----> $os"

kernel=$(uname -r)
echo "Kernel version   ----> $kernel"

mem=$(free -m)
echo -e "Memory details  ----->\n $mem"

cpu=$(lscpu | grep "Model name" | awk -F':' '{print $2}')
echo "CPU details      ----> $cpu"


