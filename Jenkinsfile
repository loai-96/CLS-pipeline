pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "Building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo 'Building the docker image...'
                    WithCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVarible: 'PASS', usernameVarible: 'USER')])
                        sh 'docker build -t loaiezayed925/my-repo:jma-2.0 .'
                        sh "echo $PASS docker login -u $USER --password-stdin"
                        sh 'docker push loaiezayed925/my-repo:jma-2.0 '
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo 'deploying the application...'
                }
            }
        }
    }
}
