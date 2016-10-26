node {
    stage('build') {
        checkout scm
        sh 'ls -la'
        sh './gradlew build'
        echo 'Build successfull!'
    }

    stage('staging deployment') {
        // some block
    }
}