pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                script {
                    // Python code to print 'Hello World'
                    sh 'python3 -c "print(\'Hello World\')"'
                }
            }
        }
    }
}

