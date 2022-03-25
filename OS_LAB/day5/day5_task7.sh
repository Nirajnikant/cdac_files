#!/bin/bash

rm -rf test
mkdir test
touch test/file{1..5}
mv test/file1 test/file1.txt
mv test/file2 test/file2.txt
mv test/file3 test/file3.txt
mv test/file4 test/file4.txt
mv test/file5 test/file5.txt



