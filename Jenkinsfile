pipeline {
  agent any
  stages {
    stage('Checkout code') {
      steps {
        script {
          echo "Cloning project from ${REPO_URL}"
          sh """
          if [ -d "${WORKDIR}" ]; then
          cd "${WORKDIR}"
          git reset --hard
          git checkout ${BRANCH}
          #git remote remove origin 2 > /dev/null || true
          #git remote add origin ${REPO_URL}
          git pull origin ${BRANCH}
          else
          git clone --branch ${BRANCH} ${REPO_URL} ${WORKDIR}
          fi
          """
        }

      }
    }

    stage('Run tests') {
      when {
        expression {
          env.RUN_TESTS == "true"
        }

      }
      steps {
        script {
          echo "Running tests"
          sh """
          mvn test -Drevision=${VERSION} -DprojectName="${PROJECT_NAME}"

          """
        }

        junit(testResults: 'target/surefire-reports/TEST-*.xml', allowEmptyResults: true, keepProperties: true, keepTestNames: true)
      }
    }

    stage('Package app') {
      steps {
        script {
          echo "Packaging the application into jar file"
          sh """
          mvn clean package -DskipTests=true -Drevision=${VERSION} -DprojectName="${PROJECT_NAME}"
          """
          archiveArtifacts "target/${PROJECT_NAME}-${VERSION}.jar"
        }

      }
    }
    stage("Deploy application"){
        steps{
            script{
                echo "Deploying the appliaction";
                sh """
                java -jar "target/${PROJECT_NAME}-${VERSION}.jar" &
                """
            }
        }
    }

  }
  tools {
    maven 'M398'
  }
  environment {
    REPO_URL = 'https://github.com/sriaaasri/jenkins-spring-project.git'
    WORKDIR = "${WORKSPACE}/springProject"
    BRANCH = 'main'
    PROJECT_NAME = 'backend'
    VERSION = 1
    RUN_TESTS = 'true'
  }
  post {
    success {
      echo 'Pipeline executed successfully.'
    }

    failure {
      echo 'Pipeline failed.'
    }

  }
}