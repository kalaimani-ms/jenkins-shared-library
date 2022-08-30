def call() {
    echo 'building the maven application Image..'
    withCredentials([usernamePassword(credentialsId: 'kalaimanims-Dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker images'
    sh 'docker build -t kalaimanims/mavenapp:1.2 .'
    sh 'docker images'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push kalaimanims/mavenapp:1.2'
    sh 'docker images'
}
}