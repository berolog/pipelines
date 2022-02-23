#!/usr/bin/env groovy

def call(String branch, String url) {
    checkout scm: [$class: 'GitSCM',
    userRemoteConfigs: [[url: url]],
    branches: [[name: branch]]],
    poll: false

}
