node {
    stage('build') {
        checkout scm
        sh 'ls -la'
        withMaven(mavenLocalRepo: '', mavenOpts: '', mavenSettingsFilePath: '') {
            sh 'mvn verify package'
        }
        echo 'Build successfull!'
    }

    stage('staging deployment') {
        // some block
    }
}