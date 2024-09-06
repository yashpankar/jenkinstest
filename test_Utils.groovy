def runLinting() {
    sh """
        docker --tlsverify \
            --tlscacert \$DOCKER_TLS_CLIENTDIR/ca.pem \
            --tlscert \$DOCKER_TLS_CLIENTDIR/cert.pem \
            --tlskey \$DOCKER_TLS_CLIENTDIR/key.pem \
            run --rm --name ai5typing --cpus="4" \
            -e TEST_BUILDING=${TEST_BUILDING} \
            -e AZURE_CLIENT_ID=${AZURE_SP_CLIENT_ID} \
            -e AZURE_CLIENT_SECRET=${AZURE_SP_CLIENT_SECRET} \
            -e AZURE_TENANT_ID=${AZURE_TENANT_ID} \
            -e TEST_PROJECT_SOURCE_FOLDER=${TEST_PROJECT_SOURCE_FOLDER} \
            -e TEST_PROJECT_TESTS_FOLDER=${TEST_PROJECT_TESTS_FOLDER} \
            ${REPO_NAME}/test:${MAJOR_VERSION}.${BUILD_NUMBER} \
            bash ${LINTING_SCRIPT_TYPING}
    """
}

def runTests() {
    sh """
        docker --tlsverify \
            --tlscacert \$DOCKER_TLS_CLIENTDIR/ca.pem \
            --tlscert \$DOCKER_TLS_CLIENTDIR/cert.pem \
            --tlskey \$DOCKER_TLS_CLIENTDIR/key.pem \
            run --rm --name ai5test --cpus="4" \
            -e TEST_BUILDING=${TEST_BUILDING} \
            -e AZURE_CLIENT_ID=${AZURE_SP_CLIENT_ID} \
            -e AZURE_CLIENT_SECRET=${AZURE_SP_CLIENT_SECRET} \
            -e AZURE_TENANT_ID=${AZURE_TENANT_ID} \
            -e TEST_PROJECT_SOURCE_FOLDER=${TEST_PROJECT_SOURCE_FOLDER} \
            -e TEST_PROJECT_TESTS_FOLDER=${TEST_PROJECT_TESTS_FOLDER} \
            ${REPO_NAME}/test:${MAJOR_VERSION}.${BUILD_NUMBER} \
            bash ${TEST_SCRIPT}
    """
}

return this
