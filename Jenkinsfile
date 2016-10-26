node {
    stage('build') {
        checkout scm
        sh 'ls -la'
        sh './mvnw verify package'
        echo 'Build successfull!'
    }

    stage('staging deployment') {
        // some block
    }
}