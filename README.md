# 12factor-demo

This is a demo application for a [12 factor application](http://12factor.net/) based on spring boot.

It shows some deployments for Deis Workflow in it's branches:

* [Buildpack Deployment](https://deis.com/docs/workflow/applications/using-buildpacks/): [master](https://github.com/nbyl/12factor-demo)
* [Dockerfile Deployment](https://deis.com/docs/workflow/applications/using-dockerfiles/): [dockerfile](https://github.com/nbyl/12factor-demo/tree/dockerfile)
* [Docker Image Deployment](https://deis.com/docs/workflow/applications/using-docker-images/): [jenkins-ci](https://github.com/nbyl/12factor-demo/tree/jenkins-ci) 


## Deis Workflow

This application contains a demo of continuous delivery pipeline using Deis Workflow and Kubernetes

 The project will be built and deployed using Jenkins and Pipeline Feature. The project will be built using the following stages:
 
 * **build**: The application will be built and tested by unit tests.
 * **publish docker container**: Publish the built container on bintray. 
 * **staging deployment**: Deploy the container in a staging environment.
 * **integration test**: Run integration tests against this staging environment (does currently nothing).
 * **wait for approval by QA**: Wait until someone authorizes the deployment to production.
 * **production deployment**: Deploy the application in the production environment.

### Prequisites

* Provision a [Kubernetes Cluster](http://kubernetes.io/) in the variant of your choice. **Note**: minkube is currently not working.
* [Install Deis Workflow](https://deis.com/docs/workflow/installing-workflow/) in your newly created cluster.
* Install the follwing CLI tools:
  * [kubectl](http://kubernetes.io/docs/user-guide/prereqs/)
  * [deis](https://deis.com/docs/workflow/quickstart/install-cli-tools/)
  * [helm](https://github.com/kubernetes/helm/blob/master/docs/quickstart.md)
  
### Prepare the repo
  
* Fork it to somewhere you can access.
* Get an accessible external docker registry. For demo purposes you can use a public repo at http://bintray.com
  
### Deis

Before doing anything else, you need to register a user:
  
    export DEIS_URL=http://deis.$(minikube ip).nip.io
    deis register ${DEIS_URL} 

You need to create two applications in your cluster:

    deis create tw-facter-staging --no-remote
    deis create tw-facter --no-remote 
  
### Jenkins

Jenkins will be installed using [helm](https://helm.sh/):

    helm init
    helm install stable/jenkins --set Agent.Memory=1024Mi
    
After helm has installed Jenkins into your cluster it will show you commands to retrieve the admin password and the URL for accessing it.

Afterwards you have to create the following secrets in jenkins:

* **bintray-docker**: As "Username and Password", the username and password for accessing the registry.
* **deis-token**: The token to access your Deis Workflow cluster. Can be retrieved from ~/.deis/config.json after logging in.

Afterward go to "Manage Jenkins" -> "Configure System" and Scroll Down to "Kubernetes Pod Templates". Add the follwing:

* Change "Docker image" to `nbyl-docker-docker.bintray.io/jnlp-slave:2.52`
* Add a "Host Path Volume" mapping `/var/run/docker.sock` to `/var/run/docker.sock`

### Create the Build Job

Create a new "Multibranch Pipeline" build job and a the repository url as the branch source. 

## heroku

This application can also be deployed to heroku using this button:

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

