node {
    stage('build') {
        checkout scm
        sh './mvnw verify package'
        echo 'Build successfull!'
    }

    stage('staging deployment') {
        // some block
    }
}