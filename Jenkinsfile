pipeline {
    agent any
     stages {
    stage('Papi') {
        steps { echo 'Esto Build' } 
    }
    stage('Chulo')  {
        steps {
            echo 'echo Test' 
            bat 'mvn -B -V test -Dtest=execution.runner.TestRunner'
        } 
    }
  }
}
