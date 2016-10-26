node {
    stage('build') {
        checkout scm
        sh 'ls -la'
        withEnv(['GRADLE_OPTS=-Dorg.gradle.daemon=false']) {
            sh './gradlew build'
        }
        echo 'Build successfull!'
    }

    stage('staging deployment') {
        // some block
    }
}