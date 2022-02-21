#!/usr/bin/env groovy

def call() {
    node {
        def cfg = pipelineCfg()

        try {
            stage('Checkout') {
                git cfg.gitRepo
            }

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
