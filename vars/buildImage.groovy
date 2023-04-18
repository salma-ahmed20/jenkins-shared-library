
def call(){
    echo 'Building docker image'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'docker build -t salma101/java-maven-app:jma-2.0 .'
        sh "echo $PASS| docker login -u $USER --password-stdin"
        sh 'docker push salma101/java-maven-app:jma-2.0'
    }
}