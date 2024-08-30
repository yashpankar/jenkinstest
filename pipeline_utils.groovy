def cleanWorkspace() {
    sh '''
        rm -f .gitinfo
        rm -rf build dist *.egg-info
        find "${TEST_PROJECT_SOURCE_FOLDER}" -name __pycache__ | xargs rm -rf
        find "${TEST_PROJECT_TESTS_FOLDER}" -name __pycache__ | xargs rm -rf
        find . -name .pytest_cache | xargs rm -rf
        find "${TEST_PROJECT_SOURCE_FOLDER}" -name "*.pyc" -delete
        rm -rf .coverage
        rm -rf "tune_results/*"
    '''
}

def loginToAzure() {
    sh '''
        az login --service-principal \
            -u ${AZURE_SP_CLIENT_ID} \
            -p ${AZURE_SP_CLIENT_SECRET} \
            --tenant ${AZURE_TENANT_ID}
    '''
}

def getK8sCredentials() {
    sh 'az aks get-credentials -n ${K8S_NAME} -g ${K8S_RG}'
}

return this
