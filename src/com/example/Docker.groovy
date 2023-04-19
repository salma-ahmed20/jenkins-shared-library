package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildImage(String imageName) {
        script.echo 'Building docker image from shared lib class'
        script.sh "docker build -t salma101/$imageName ."
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            script.sh "echo $script.PASS| docker login -u $script.USER --password-stdin"
        }
    }

    def pushImage(String imageName) {
        script.sh "docker push salma101/$imageName"
    }

}
