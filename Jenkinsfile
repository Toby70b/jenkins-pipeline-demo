pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage('Build') {
            steps { sh 'mvn -B clean package' }
        }
        stage('Test') {
            steps { sh 'mvn test' }
            post {
                always { junit 'target/surefire-reports/*.xml' }
            }
        }
    }
    post {
            success {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
}