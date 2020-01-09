pipeline {
    agent {
        docker {
            image 'adb_demo6'
            args '-ti --privileged -v /dev/bus/usb:/dev/bus/usb'}
    }
    environment {
            HOME = '.'
            SDK_URL="https://dl.google.com/android/repository/sdk-tools-linux-3859397.zip"
            ANDROID_HOME="/usr/local/android-sdk"
            ANDROID_VERSION=28
            ANDROID_BUILD_TOOLS_VERSION=27.0.3
    }
    stages {
        stage('env') {
            steps {
                sh 'id'
                sh 'whoami'
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
