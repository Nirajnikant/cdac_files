#!/bin/bash

count=$(ls | wc -l)
echo "Total files ------> $count"
pdf=$(ls | grep ".pdf" | wc -l)
echo ".pdf ----> $pdf"
docx=$(ls | grep ".docx" | wc -l)
echo ".docx ----> $docx"

for file in *.pdf
do
    mv -v "$file" "${file%.pdf}.docx"
done;

pdf1=$(ls | grep ".pdf" | wc -l)
echo ".pdf ----> $pdf1"
docx1=$(ls | grep ".docx" | wc -l)
echo ".docx ----> $docx1"

un=$(ls | grep "_")
echo -e "files with _ \n$un"
