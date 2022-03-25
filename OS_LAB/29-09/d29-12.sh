#!/bin/bash

read -p "Enter file path " file
sed -i '/^$/d' $file
