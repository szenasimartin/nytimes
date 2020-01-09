#!/bin/bash -e

cd ${WORKSPACE}

export PATH=$PATH:/usr/local/bin

echo "\n"
echo "mkdir"
mkdir //.android
echo "adb"
adb devices
