pipeline {
    agent {
        docker {
            image 'adb_demo11'
            args '-ti --privileged -v /dev/bus/usb:/dev/bus/usb'}
    }
    environment {
            HOME = '.'
            SDK_URL="https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip"
            ANDROID_HOME="/home/myuser/android-sdk"
            ANDROID_VERSION=29
            ANDROID_BUILD_TOOLS_VERSION="28.0.3"
    }
    stages {
        stage('env') {
            steps {
                sh 'id'
                sh 'whoami'
                sh 'groups'
            }
        }
        stage('Build') {
            steps {
                checkout scm
                sh '''#!/bin/bash
                $WORKSPACE/scripts/build.sh
                '''
            }
        }
    }
}
