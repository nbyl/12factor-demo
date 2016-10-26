node {
    stage('build') {
        checkout scm
        withEnv(['GRADLE_OPTS=-Dorg.gradle.daemon=false']) {
            sh './gradlew build'
        }
        echo 'Build successfull!'
    }

    stage('publish docker container') {
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'bintray-docker', passwordVariable: 'BINTRAY_KEY', usernameVariable: 'BINTRAY_USER']]) {
            sh './gradlew publishImage'
        }
    }

    stage('staging deployment') {
        withCredentials([[$class: 'StringBinding', credentialsId: 'deis-token', variable: 'DEIS_TOKEN']]) {
            sh './gradlew deploy -PappName=tw-facter-staging'
        }
    }

    stage('integration test') {
        sh 'sleep 10'
        echo 'All Tests Good!'
    }
}