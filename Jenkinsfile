pipeline {
  agent none
  stages {
    stage('Build') {
      steps {
        build(job: 'Build', quietPeriod: 2, wait: true, propagate: true)
      }
    }

  }
}