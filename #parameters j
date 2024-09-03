def gv

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'excuteTests', defaultValue: true, description: '')
    }
    stages {
        stage ("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {
            when {
                expression {
                    params.excuteTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
                }
        }
        stage("deploy") {
            input {
                message "select the enviroment to deploy to"
                ok "done"
                parameters {
                  choice(name: 'ENV', choices: ['dev', 'staging', 'prod'], description: '')  
                }
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
