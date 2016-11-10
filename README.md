# 12factor-demo

This is a demo application for a [12 factor application](http://12factor.net/) based on spring boot.

It shows some deployments for Deis Workflow in it's branches:

* [Buildpack Deployment](https://deis.com/docs/workflow/applications/using-buildpacks/): [master](https://github.com/nbyl/12factor-demo)
* [Dockerfile Deployment](https://deis.com/docs/workflow/applications/using-dockerfiles/): [dockerfile](https://github.com/nbyl/12factor-demo/tree/dockerfile)
* [Docker Image Deployment](https://deis.com/docs/workflow/applications/using-docker-images/): [jenkins-ci](https://github.com/nbyl/12factor-demo/tree/jenkins-ci) 

## Deis Workflow

### Prequisites

* Provision a [Kubernetes Cluster](http://kubernetes.io/) in the variant of your choice.
* [Install Deis Workflow](https://deis.com/docs/workflow/installing-workflow/) in your newly created cluster.
* Install the follwing CLI tools:
  * [kubectl](http://kubernetes.io/docs/user-guide/prereqs/)
  * [deis](https://deis.com/docs/workflow/quickstart/install-cli-tools/)
  
### Deploy
  
    deis create tw-facter-slug
    deis push master
    deis open

## heroku

This application can also be deployed to heroku using this button:

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)
