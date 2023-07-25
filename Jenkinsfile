
pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
    }

    stages {
    	stage('Checkout code from SCM - github jenins file')
    	{
    		steps{
	    		echo 'checking out code from SCM -gitHub'
			echo 'new Code is added here.'
	    		//code
    		}
    	}
     	
        stage('Get source code from git repo') {
            steps {
                // Get some code from a GitHub repository
               git branch: 'main', url: 'https://github.com/GITShrutip/ClassicCRM-BDD.git'
           
            }
            }
        stage('Cleaning stage'){
            steps{
                bat 'mvn clean'
            }
        }
         stage('Build and Run'){
            steps{
                bat 'mvn test'
            }
        }
       
	}
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    echo 'Build successfull'
                }
            }
        
    
}
