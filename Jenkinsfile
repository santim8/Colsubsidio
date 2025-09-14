pipeline {
    agent any
     stages {
    stage('Papi') {
        steps { echo 'Esto Build' } 
    }
    stage('Chulo')  {
        steps {
            echo 'echo Test' 
            mvn test "-Dtest=execution.runner.TestRunner"
        } 
    }
  }
}
