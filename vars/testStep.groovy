#!/usr/bin/env groovy

def call() {
    sh './test.sh > test_results.txt'
}
