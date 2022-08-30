def call(String imagename) {
    echo 'building the maven application Image..'
    withCredentials([usernamePassword(credentialsId: 'kalaimanims-Dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker images'
    sh "docker build -t $imagename ."
    sh 'docker images'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    // $imagename varible described in muti.jenkinsfile java maven app Repostory
    sh "docker push $imagename"
    sh 'docker images'
}
}
