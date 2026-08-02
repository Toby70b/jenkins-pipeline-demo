pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage('Compile') {
            steps { sh 'mvn -B clean compile' }
        }
        stage('Test') {
            steps { sh 'mvn test' }
            post {
                always { junit 'target/surefire-reports/*.xml' }
            }
        }
        stage('Package') {
            steps { sh 'mvn -B package -DskipTests' }
        }
    }
    post {
            success {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
}