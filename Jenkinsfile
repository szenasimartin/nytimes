pipeline {
    agent {
        docker { image 'adb_demo' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'adb devices'
            }
        }
    }
}
