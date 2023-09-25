pipeline {
	agent any
	environment {
		mavenHome = tool 'my-maven'
	}

	stages {
		stage('Build'){
			steps {
				sh "mvn clean install"
			}
		}
	}
}
