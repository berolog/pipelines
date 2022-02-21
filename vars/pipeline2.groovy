#!/usr/bin/env groovy

def call() {
    node {

        try {
            stage('Checkout') {
                git 'https://github.com/berolog/scripts.git'
            }

            def cfg = pipelineCfg()

            stage('Build') {
                sh cfg.buildCommand
            }

            stage('Test') {
                sh "${cfg.testCommand} > ${cfg.failureArtifact}"
            }

            currentBuild.result = 'SUCCESS'
        }

        catch(e) {
            archiveArtifacts artifacts: cfg.failureArtifact
            currentBuild.result = 'FAILURE'
            throw e
        }

        finally {
            writeFile file: cfg.alwaysArtifact, text: currentBuild.result
            archiveArtifacts artifacts: cfg.alwaysArtifact
        }
    }
}
