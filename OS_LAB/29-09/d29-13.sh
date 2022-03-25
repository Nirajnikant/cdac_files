#!/bin/bash

ifconfig | grep -Po "inet \d+\.\d+\.\d+\.\d+" | grep -v "inet 127"

