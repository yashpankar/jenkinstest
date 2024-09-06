def buildDockerImage(String imageName, String dockerfile, Map buildArgs) {
    def argString = buildArgs.collect { k, v -> "--build-arg \"${k}=${v}\"" }.join(' ')
    sh """
        docker --tlsverify \
            --tlscacert \$DOCKER_TLS_CLIENTDIR/ca.pem \
            --tlscert \$DOCKER_TLS_CLIENTDIR/cert.pem \
            --tlskey \$DOCKER_TLS_CLIENTDIR/key.pem \
            build -t ${imageName} \
            ${argString} \
            -f ${dockerfile} .
    """
}

def pushDockerImage(String imageName) {
    sh """
        docker --tlsverify \
            --tlscacert \$DOCKER_TLS_CLIENTDIR/ca.pem \
            --tlscert \$DOCKER_TLS_CLIENTDIR/cert.pem \
            --tlskey \$DOCKER_TLS_CLIENTDIR/key.pem \
            push ${imageName}
    """
}

def runDockerContainer(String imageName, String command) {
    sh """
        docker --tlsverify \
            --tlscacert \$DOCKER_TLS_CLIENTDIR/ca.pem \
            --tlscert \$DOCKER_TLS_CLIENTDIR/cert.pem \
            --tlskey \$DOCKER_TLS_CLIENTDIR/key.pem \
            run --rm ${imageName} ${command}
    """
}

def dockerLogin(String dockerTlsClientDir, String azureSpClientId, String azureSpClientSecret, String baseImageRepoUrl) {
    sh """
        docker --tlsverify \
            --tlscacert ${dockerTlsClientDir}/ca.pem \
            --tlscert ${dockerTlsClientDir}/cert.pem \
            --tlskey ${dockerTlsClientDir}/key.pem \
            login -u ${azureSpClientId} -p ${azureSpClientSecret} ${baseImageRepoUrl}
    """
}

def dockerLogout(String dockerTlsClientDir) {
    sh """
        docker --tlsverify \
           --tlscacert $dockerTlsClientDir/ca.pem \
           --tlscert $dockerTlsClientDir/cert.pem \
           --tlskey $dockerTlsClientDir/key.pem \
           logout
    """
}

return this
