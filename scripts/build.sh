#!/bin/bash -e

cd ${WORKSPACE}

export PATH=$PATH:/usr/local/bin

echo "\n"
adb devices
${WORKSPACE}/gradlew connectedAndroidTest
