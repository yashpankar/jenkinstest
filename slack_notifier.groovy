def sendSlackNotification(String channel, String message, String color) {
    slackSend(channel: channel, message: message, color: color)
}

def buildStartMessage() {
    return """
    *Job Start:*
    Pipeline Name: ${env.JOB_NAME} Build: ${env.BUILD_NUMBER}
    *Git info:*
    Branch: ${env.GIT_BRANCH}, Hash: ${env.GIT_COMMIT}
    *More info at:*
    ${env.BUILD_URL}
    """.stripIndent()
}

def buildEndMessage() {
    return """
    *${currentBuild.currentResult}:*
    Pipeline name: ${env.JOB_NAME}, Build: ${env.BUILD_NUMBER}
    *Git info:*
    Branch: ${env.GIT_BRANCH}, Hash: ${env.GIT_COMMIT}
    *More info at:*
    ${env.BUILD_URL}
    """.stripIndent()
}

return this

