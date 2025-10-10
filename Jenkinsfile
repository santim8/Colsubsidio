pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
         echo 'echo Test new' 
         bat 'mvn test -Dsurefire.suiteXmlFiles=src/test/resources/suitTest.xml'
      }
    }
  }
}

