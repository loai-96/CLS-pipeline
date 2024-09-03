def builJar() {
     echo "Building the application..."
     sh 'mvn package'
}

def buildImage() {
     echo 'Building the docker image...'
    /* groovylint-disable-next-line LineLength */
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t loaiezayed925/my-repo:jma-2.0 .'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push loaiezayed925/my-repo:jma-2.0 '
    }
}
return this
