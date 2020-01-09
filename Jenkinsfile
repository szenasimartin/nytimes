pipeline {
    agent {
        docker {
            image 'adb-demo2'
            args '-ti --privileged -v /dev/bus/usb:/dev/bus/usb'}
    }
    environment {
            HOME = '.'
    }
    stages {
        stage('env') {
            steps {
                sh 'id'
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
