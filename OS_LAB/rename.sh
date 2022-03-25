#!/bin/bash

for file in *.docx
do
    mv -v "$file" "${file%.docx}.pdf"
done;
