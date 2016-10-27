# 12factor-demo

This is a demo application for a [12 factor application](http://12factor.net/) based on spring boot.

## heroku

This application can also be deployed to heroku using this button:

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

## Deis Workflow

This application contains a demo of continuous delivery pipeline using Deis Workflow and Kubernetes

 The project will be built and deployed using Jenkins and Pipeline Feature. The project will be built using the following stages:
 
 * **build**: The application will be built and tested by unit tests.
 * **publish docker container**: 
 * **staging deployment**:
 * **integration test**:
 * **wait for approval by QA**:
 * **production deployment**:
TODO: rest of the stages

### Prequisites

* Provision a [Kubernetes Cluster](http://kubernetes.io/) in the variant of your choice. **Note**: minkube is currently not working.
* [Install Deis Workflow](https://deis.com/docs/workflow/installing-workflow/) in your newly created cluster.
* Install the follwing CLI tools:
  * [kubectl](http://kubernetes.io/docs/user-guide/prereqs/)
  * [deis](https://deis.com/docs/workflow/quickstart/install-cli-tools/)
  * [helm](https://github.com/kubernetes/helm/blob/master/docs/quickstart.md)
  
### Deis
  
(TODO: Registration and App Setup)  

### Jenkins

Jenkins will be installed using [helm](https://helm.sh/):

    helm init
    helm install stable/jenkins --set Agent.Memory=1024Mi
    
After helm has installed Jenkins into your cluster it will show you commands to retrieve the admin password and the URL for accessing it.

Afterwards you have to create the following global secrets in jenkins:

* **bintray-docker**: As "Username and Password", the username and password for accessing the registry.
* **deis-token**: The token to access your Deis Workflow cluster. Can be retrieved from ~/.deis/config.json after logging in.

### Create the Build Job

(TODO)