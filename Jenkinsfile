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
	 stage('SSH into EC2') {
            steps {
                script {
                    // Load the SSH key from Jenkins credentials
                    def sshKey = credentials('my-ec2-secrets')

                    // Use the SSH agent to temporarily add the key
                    sshagent(['my-ec2-secrets']) {
                        // SSH into the EC2 instance
                        sh "ssh -i ${sshKey} ec2-15-206-185-97.ap-south-1.compute.amazonaws.com   
			    'scp /var/lib/jenkins/workspace/contact-manger/target/contact-manger-jpa-0.0.1-SNAPSHOT.jar ./temp'
			    'java -jar  ./temp/contact-manger-jpa-0.0.1-SNAPSHOT.jar'
			    "                
		    }
                }
            }
        }
	}
}
