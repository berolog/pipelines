#!/usr/bin/env groovy

def call() {
    Map pipelineCfg = readYaml(file: "${WORKSPACE}/cfg.yaml")
    return pipelineCfg
}
