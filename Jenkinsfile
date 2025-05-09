pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven 'maven-3.9'
    }

    stages {
        stage('Debug') {
            steps {
                sh 'find src -type f | sort || echo "No files found"'
                sh 'ls -la src/test/java/com/example/demo/ || echo "Directory not found"'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn -B test'
            }
        }

        stage('Generate HTML Report') {
            steps {
                sh 'mvn surefire-report:report'
                publishHTML(target: [
                    reportName : 'Surefire Test Report',
                    reportDir  : 'target/reports',
                    reportFiles: 'surefire.html',
                    keepAll    : true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }


        stage('Archive Results') {
            steps {
                junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        success {
            echo '✅ Build erfolgreich'
        }
        failure {
            echo '❌ Build fehlgeschlagen'
        }
        always {
            echo 'Test-Report-Pfad: ${WORKSPACE}/target/surefire-reports/'
            sh 'ls -la ${WORKSPACE}/target/surefire-reports/ || echo "Keine Test-Reports gefunden"'
        }
    }
}