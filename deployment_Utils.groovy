def deployToHelm(String namespace, String releaseName, String chartDir, String valuesFile, Map imageDetails) {
    sh """
        helm -n ${namespace} upgrade --install \
            --set image.repository=${imageDetails.repository} \
            --set image.tag=${imageDetails.tag} \
            ${releaseName} ${chartDir} -f ${valuesFile}
    """
}

return this
