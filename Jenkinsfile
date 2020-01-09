pipeline {
    agent {
        docker {
            image 'adb_demo'
            args '-ti --privileged'}
    }
    stages {
        stage('Test') {
            steps {
                sh 'adb devices'
            }
        }
    }
}
