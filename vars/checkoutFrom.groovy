#!/usr/bin/env groovy

def call(String branch, String url) {
    git branch: branch
    url: url
}
