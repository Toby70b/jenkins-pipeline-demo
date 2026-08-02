pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    parameters {
        choice(name: 'ENVIRONMENT', choices: ['dev','staging','prod'], description: 'target enviornment')
        booleanParam(name: 'SKIP_TESTS', defaultValue: false, description: 'Skip the test stage')
    }
    stages {
        stage('Compile') {
            steps { sh 'mvn -B clean compile' }
        }
        stage('Test') {
            when {
                expression { return params.SKIP_TESTS }
            }
            steps { sh 'mvn test' }
            post {
                always { junit 'target/surefire-reports/*.xml' }
            }
        }
        stage('Package') {
            steps {
                echo "packaging the application for ${params.ENVIRONMENT} environment"
                sh 'mvn -B package -DskipTests'
             }
        }
    }
    post {
            success {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
}