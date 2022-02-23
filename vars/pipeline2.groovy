#!/usr/bin/env groovy

def call() {
    node {

        try {
            stage('Checkout') {
                git 'https://github.com/berolog/scripts.git'
            }

            /* def cfg = pipelineCfg() */

            stage('Build') {
                sh './build.sh'
            }

            stage('Test') {
                sh "./test.sh > test_results.txt"
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
