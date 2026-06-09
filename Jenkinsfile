pipeline{
    agent any

    stages{
        stage("hello world"){
            steps{
                echo "${WORKSPACE}"
                echhho "Hello world"
            }
        }
    }

    post{
        success {
            echo "Pipeline executed successfully."
        }
        failure {
            echo "Pipeline failed."
        }
    }
}
