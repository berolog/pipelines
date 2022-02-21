#!/usr/bin/env groovy

def call(String pipeline) {
    Map pipelineCfg = readYaml(file: "${WORKSPACE}/${pipeline}/cfg.yaml")
    return pipelineCfg
}
