#!/usr/bin/env groovy

def call(String mvn=null) {
    if (mvn == null) {
        sh './test.sh > test_results.txt'
    }
    else {
        sh "${mvn} test"
    }
}
