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
                        scp -o StrictHostKeyChecking=no -i ${SSH_KEY} /var/lib/jenkins/workspace/contact-manger/target/contact-manger-jpa-0.0.1-SNAPSHOT.jar ubuntu@3.108.59.128:~
                        ssh -o StrictHostKeyChecking=no -i ${SSH_KEY} ubuntu@3.108.59.128 'java -jar ~/contact-manger-jpa-0.0.1-SNAPSHOT.jar'
                    """
                }
            }
        }
    }
}
