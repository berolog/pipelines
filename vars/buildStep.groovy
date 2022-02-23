#!/usr/bin/env groovy

def call(String mvn=null) {
    if (mvn == null) {
        sh './build.sh'
    } 
    
    else {
        sh 'mvn clean install'
        sh 'mvn hpi:hpi'
    }
}
