node {
    stage('build') {
        checkout scm
        sh 'ls -la'
        sh './gradlew'
        echo 'Build successfull!'
    }

    stage('staging deployment') {
        // some block
    }
}