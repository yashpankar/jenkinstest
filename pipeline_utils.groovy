def cleanWorkspace() {
    sh '''
        echo "first: ${TEST_PROJECT_SOURCE_FOLDER}" 
        echo "second: ${TEST_PROJECT_TESTS_FOLDER}"
        echo "third: ${TEST_PROJECT_SOURCE_FOLDER}" 
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
