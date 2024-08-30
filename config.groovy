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
        SETUP_DEV_SCRIPT: '/home/optimizer/ai5/deploymentk8s/makescripts/setupdevtool.sh',
        LINTING_SCRIPT_TYPING: '/home/optimizer/ai5/deploymentk8s/makescripts/lintandtyping.sh',
        TEST_SCRIPT: '/home/optimizer/ai5/deploymentk8s/makescripts/maketest.sh',
        TEST_PROJECT_SOURCE_FOLDER: 'aimy',
        TEST_PROJECT_TESTS_FOLDER: 'tests',
    ]
}
return this
