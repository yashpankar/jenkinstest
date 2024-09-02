def buildDockerImage() {
     echo "docker build"
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

def dockerLogin() {
       echo "docker login"
}

return this
