pipeline {
    agent any
     stages {
    stage('Papi') {
        steps { echo 'Esto Build' } 
    }
    stage('Chulo')  {
        steps {
            echo 'echo Test' 
            bat 'mvn test -Dtest=execution.runner.TestRunner'
            bat 'mvn test -Dsurefire.suiteXmlFiles=src/test/resources/suitTest.xml'
        } 
    }
  }
}
