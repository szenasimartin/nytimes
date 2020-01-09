pipeline {
    agent {
        docker {
            image 'adb_demo'
            args '-ti --privileged'}
    }
    stages {
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
