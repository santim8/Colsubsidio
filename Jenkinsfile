pipeline {
    agent any
    stages {
        stage("Clean Up"){
            steps {
                deleteDir()
            }
        }
        stage("Clone Repo") {
            steps {
                sh ""
                sh "git clone https://github.com/santim8/Colsubsidio.git"
            }
        }
        stage("Build"){
            steps {
                dir("simple-java-maven-app") {
                    sh "mvn clean install"
                }
            }
        }

        stage("Test"){
            steps {
                dir("simple-java-maven-app"){
                    sh "mvn test"
                }
            }
        }
    }
}