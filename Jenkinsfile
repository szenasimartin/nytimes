pipeline {
    agent {
        docker {
            image 'adb_demo'
            args '-ti --privileged'}
    }
    environment {
            HOME = '.'
    }
    stages {
        stage('env') {
            steps {
                sh 'id'
                sh 'whoami'
                sh 'pwd'
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
