#!/bin/bash

read -p "Enter a no. " num
 
case $num in
  [0-9])
    printf '\nSINGLE DIGIT NUMBER!'
    ;;
  [0-9][0-9])
    printf '\nDOUBLE DIGIT NUMBER!'
    ;;
  *)
    printf >&2 '\nINVALID INPUT!'
    ;;
esac
