pipeline {
    agent any

    stages {
        stage('Build') {
            tools {
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
                        // SCP the JAR file to the EC2 instance
                        sh "scp -i ${sshKey} /var/lib/jenkins/workspace/contact-manger/target/contact-manger-jpa-0.0.1-SNAPSHOT.jar ec2-user@ec2-15-206-185-97.ap-south-1.compute.amazonaws.com:~/temp/"

                        // SSH into the EC2 instance and start the application
                        sh "ssh -i ${sshKey} ec2-user@ec2-15-206-185-97.ap-south-1.compute.amazonaws.com 'java -jar ~/temp/contact-manger-jpa-0.0.1-SNAPSHOT.jar'"
                    }
                }
            }
        }
    }
}
