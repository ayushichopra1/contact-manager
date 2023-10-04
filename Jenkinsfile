pipeline {
    agent any
     tools {
                maven 'my-maven' 
     }
    stages {
        stage('Build') {
            steps {
                sh "mvn -v"
                sh "mvn clean install"
            }
        }
        stage('SSH into EC2') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: 'my-ec2-secrets', keyFileVariable: 'SSH_KEY')]) {
                    sh """
                        scp -o StrictHostKeyChecking=no -i ${SSH_KEY} /var/lib/jenkins/workspace/contact-manger/target/contact-manger-jpa-0.0.1-SNAPSHOT.jar ubuntu@15.207.20.48:~
                        ssh -o StrictHostKeyChecking=no -i ${SSH_KEY} ubuntu@15.207.20.48 'java -jar ~/contact-manger-jpa-0.0.1-SNAPSHOT.jar'
                    """
                }
            }
        }
    }
}
