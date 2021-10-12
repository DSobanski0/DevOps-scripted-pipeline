pipeline {
	agent any

	tools {
		maven "apache-maven"
	}

	stages {
		stage('Build') {
			steps {
				git 'https://github.com/DSobanski0/DBE-Challenge-LetMeWalk.git'
				sh "mvn -Dmaven.test.failure.ignore=true clean package"
			}

			post {
				success {
					junit '**/target/surefire-reports/TEST-*.xml'
					archiveArtifacts 'target/*.jar'
				}
			}
		}

		stage('Deploy') {
			steps {
				echo 'Realizando o Deploy em Desenvolvimento...'
				sleep 5
			}
		}
	}
}