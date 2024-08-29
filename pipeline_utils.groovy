def cleanWorkspace() {
    sh '''
        rm -f .gitinfo
        rm -rf build dist *.egg-info
        rm -rf .coverage
        rm -rf "tune_results/*"
    '''
}

return this
