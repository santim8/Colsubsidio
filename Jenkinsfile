pipeline {
    agent any
    }
    stage('Chulo')  {
        steps {
            echo 'echo Test' 
         //   bat 'mvn test -Dtest=execution.runner.TestRunner'
            bat 'mvn test -Dsurefire.suiteXmlFiles=src/test/resources/suitTest.xml'
        } 
    }
  }
}
