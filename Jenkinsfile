
pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
    }

    stages {
    	stage('Checkout code from SCM - github jenins file')
    	{
    		step{
	    		echo 'checking out code from SCM -gitHub'
	    		//code
    		}
    	}
     	
        stage('Get source code from git repo') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/GITShrutip/ClassicCRM-BDD.git'
           
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
       

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}