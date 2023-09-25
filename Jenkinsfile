pipeline {
	agent any

	stages {
		stage('Build'){
			tools{
				maven 'my-maven'
			}
			steps {
				sh "mvn -v"
				sh "mvn clean install"
			}
		}
	}
}
