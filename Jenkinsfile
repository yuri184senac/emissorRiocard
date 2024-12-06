pipeline {
    agent any

    stages {
        stage('Verificar Repositorio') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']],
                          userRemoteConfigs: [
                                [
                                    url: 'https://github.com/yuri184senac/emissorRiocard.git'
                                 ]]])
            }
        }



        stage('Construir Imagem Docker') {
            steps {
                script {
                    def appName = 'emissorMicroservicoApp'
                    def imageTag = "${appName}:${env.BUILD_ID}"
                    bat "docker build --build-arg SPRING_PROFILES_ACTIVE=${DEPLOY_PROFILE} -t ${imageTag} ."
                }
            }
        }

        stage('Fazer Deploy') {
            steps {
                script {
                    def appName = 'emissorMicroservicoApp'
                    def imageTag = "${appName}:${env.BUILD_ID}"
                    bat "docker stop ${appName} || exit 0"
                    bat "docker rm ${appName} || exit 0"
                    bat "docker-compose up -d --build"
                }
            }
        }
    }

    post {
        success {
            echo 'Deploy realizado com sucesso!'
        }
        failure {
            echo 'Houve um erro durante o deploy.'
        }
    }
}
