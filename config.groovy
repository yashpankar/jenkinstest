def getConfig() {
    return [
        TEST_BUILDING: '1108',
        SLACK_CHANNEL: 'jenkins-bot',
        REPO_NAME: 'ai5cicd',
        MAJOR_VERSION: '2',
        TRAIN_NAMESPACE: 'prod-ai5',
        TRAIN_DEPLOYMENT_MANIFEST: './deploymentk8s/train/prod/train-deployment.yaml',
        TRAIN_K8S_RESOURCE_FOLDER: './deploymentk8s/train/prod/',
        TRAIN_CONTAINER_NAME: 'train',
        OPTIMIZER_NAMESPACE: 'prod-ai5',
        OPTIMIZER_DEPLOYMENT_MANIFEST: './deploymentk8s/optimizer/prod/optimizer-deployment.yaml',
        OPTIMIZER_K8S_RESOURCE_FOLDER: './deploymentk8s/optimizer/prod/',
        OPTIMIZER_CONTAINER_NAME: 'optimizer',
         // Testing
        SETUP_DEV_SCRIPT: '/home/optimizer/ai5/deploymentk8s/makescripts/setupdevtool.sh',
        LINTING_SCRIPT_TYPING: '/home/optimizer/ai5/deploymentk8s/makescripts/lintandtyping.sh',
        TEST_SCRIPT: '/home/optimizer/ai5/deploymentk8s/makescripts/maketest.sh',
        TEST_PROJECT_SOURCE_FOLDER: 'aimy',
        TEST_PROJECT_TESTS_FOLDER: 'tests',
        // Dockerfile Args
        AI5_BASE_IMAGE: 'myrspovendevopskubernetescr.azurecr.io/ai5baseimage:1.00',
        AI5_USER: 'optimizer',
        AI5_USER_ID: '1000',
        // Dockerfile path
        DOCKERFILE_PATH_BASE: './deploymentk8s/docker/Dockerfile',
        DOCKERFILE_PATH_DEV: './deploymentk8s/docker/Dockerfile-addDevDependencies',
        DOCKERFILE_PATH_ADD_PROD_ENV: './deploymentk8s/docker/Dockerfile-addProdEnv',
        DOCKERFILE_PATH_ADD_TEST_ENV: './deploymentk8s/docker/Dockerfile-addTestEnv',
        // Base nvidia image repository URL
        BASE_IMAGE_REPO_URL: 'myrspovendevopskubernetescr.azurecr.io',
        // Azure service principle credentials saved in jenkins
        AZURE_SP: "credentials('AZURE_SP')",
    ]
}
return this
