pipeline {
   agent any

   stages {
      stage('Gradle Build') {
        steps {
          echo 'Building...'
          echo "Running ${env.BUILD_ID} ${env.BUILD_DISPLAY_NAME} on ${env.NODE_NAME} and JOB ${env.JOB_NAME}"
          sh './gradlew clean build -x test'
        }
     }
      stage('Test') {
        steps {
           echo 'Testing...'
           //sh './gradlew test'
        }
      }
      stage('Deploy') {
        steps {
          echo 'Deploying...'
        }
     }
  }
  post {
      success {
          mail to: '1124782639@qq.com',
               subject: "Succeed Pipeline: ${currentBuild.fullDisplayName}",
               body: "Succeed with ${env.BUILD_URL}"
      }
  }

}