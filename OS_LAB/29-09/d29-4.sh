#!/bin/bash

read -p "Enter a username" usr

useradd -s /sbin/nologin -p $usr $usr
