def setupSecretEnv() {
    sh '''
        echo CLIENT_ID=${CLIENT_ID}>> "./deploymentk8s/envs/.env-ai-test"
        echo CLIENT_SECRET=${CLIENT_SECRET}>> "./deploymentk8s/envs/.env-ai-test"
        echo CLIENT_ID=${CLIENT_ID}>> "./deploymentk8s/envs/.env-ai-prod"
        echo CLIENT_SECRET=${CLIENT_SECRET}>> "./deploymentk8s/envs/.env-ai-prod"
    '''
}

def setupOwm_KeyEnv() {
    sh '''
        echo OWM_API_KEY=${OWM_API_KEY}>> "./deploymentk8s/envs/.env-ai-prod"
        echo OWM_API_KEY=${OWM_API_KEY}>> "./deploymentk8s/envs/.env-ai-test"

        echo BRANCH_NAME=${GIT_BRANCH}>> "./deploymentk8s/envs/.env-ai-test"
        echo COMMIT_HASH=${GIT_COMMIT}>> "./deploymentk8s/envs/.env-ai-test"
        echo BRANCH_NAME=${GIT_BRANCH}>> "./deploymentk8s/envs/.env-ai-prod"
        echo COMMIT_HASH=${GIT_COMMIT}>> "./deploymentk8s/envs/.env-ai-prod"
    '''
}

def setupGitEnv() {
    sh '''
        echo BRANCH_NAME=${GIT_BRANCH}>> "./deploymentk8s/envs/.env-ai-test"
        echo COMMIT_HASH=${GIT_COMMIT}>> "./deploymentk8s/envs/.env-ai-test"
        echo BRANCH_NAME=${GIT_BRANCH}>> "./deploymentk8s/envs/.env-ai-prod"
        echo COMMIT_HASH=${GIT_COMMIT}>> "./deploymentk8s/envs/.env-ai-prod"
    '''
}

return this
