pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'excuteTests', defaultvalue: true, description: '')
    }
    stages {
        stage("build") {
            steps {
                echo 'Building the application...'
            }
        }
        stage("test") {
            when {
                expression {
                    params.excuteTests
                }
            }
            steps {
                    echo 'Testing the application...'
                }
        }
        stage("deploy") {
            steps {
                echo 'Deploying the application...'
                echo "deploying version ${params.VERSION}"
            }
        }
    }
}
