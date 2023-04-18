
def call(){
    echo 'Building docker image from shared lib'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'docker build -t salma101/java-maven-app:jma-3.0 .'
        sh "echo $PASS| docker login -u $USER --password-stdin"
        sh 'docker push salma101/java-maven-app:jma-3.0'
    }
}