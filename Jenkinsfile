pipeline {
    agent {
        docker {
            image 'adb_demo'
            args '--privileged'}
    }
    stages {
        stage('Test') {
            steps {
                sh 'adb devices'
            }
        }
    }
}
