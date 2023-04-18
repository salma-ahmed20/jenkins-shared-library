
def call(String imageName){
    echo 'Building docker image from shared lib'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t salma101/$imageNme ."
        sh "echo $PASS| docker login -u $USER --password-stdin"
        sh "docker push salma101/$imageName"
    }
}