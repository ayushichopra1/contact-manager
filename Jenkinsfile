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
                        scp -i ${SSH_KEY} /var/lib/jenkins/workspace/contact-manger/target/contact-manger-jpa-0.0.1-SNAPSHOT.jar ubuntu@ec2-15-206-185-97.ap-south-1.compute.amazonaws.com:~/temp/
                    //    ssh -i ${SSH_KEY} ubuntu@15.206.185.97 'java -jar ~/temp/contact-manger-jpa-0.0.1-SNAPSHOT.jar'
                    """
                }
            }
        }
    }
}
