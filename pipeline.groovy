pipeline {
    agent any
    
    stages {
        stage('Prepare') {
            steps {
                // Install build tools if not available
                script {
                    // Example for installing build tools (if necessary)
                    sh 'sudo apt-get update && sudo apt-get install -y build-essential'
                }
            }
        }
        
        stage('Build') {
            steps {
                script {
                    // Create a simple C++ hello_world.cpp file
                    def cppCode = '''
                    #include <iostream>
                    using namespace std;

                    int main() {
                        for(int i = 0; i < 5; i++) {
                            cout << "Hello, World!" << endl;
                        }
                        return 0;
                    }
                    '''
                    
                    // Write the C++ code to a file
                    writeFile file: 'hello_world.cpp', text: cppCode
                }
            }
        }

        stage('Compile') {
            steps {
                script {
                    // Compile the C++ program
                    sh 'g++ hello_world.cpp -o hello_world'
                }
            }
        }

        stage('Run') {
            steps {
                script {
                    // Run the compiled C++ program
                    sh './hello_world'
                }
            }
        }
    }
}
