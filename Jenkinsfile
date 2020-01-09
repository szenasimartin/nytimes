pipeline {
    agent {
        docker {
            image 'adb_demo3'
            args '-ti --privileged -v /dev/bus/usb:/dev/bus/usb'}
    }
    environment {
            HOME = '.'
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
