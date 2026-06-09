pipeline{
    agent any

    stages{
        stage("hello world"){
            steps{
                echo "${WORKSPACE}"
                echo "Hello world"
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