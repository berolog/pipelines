#!/usr/bin/env groovy

def call() {
    node {

        try {
            stage('Checkout') {
                checkoutFrom('master', 'https://github.com/berolog/scripts.git')
            }

            stage('Build') {
                buildStep()
            }

            stage('Test') {
                testStep()
            }

            currentBuild.result = 'SUCCESS'
        }

        catch(e) {
            archiveArtifacts artifacts: 'test_results.txt'
            currentBuild.result = 'FAILURE'
            throw e
        }

        finally {
            writeFile file: 'artifact.txt', text: currentBuild.result
            archiveArtifacts artifacts: 'artifact.txt'
        }
    }
}
