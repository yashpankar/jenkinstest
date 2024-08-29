def cleanWorkspace() {
    sh '''
        rm -f .gitinfo
        rm -rf build dist *.egg-info
        rm -rf .coverage
        rm -rf "tune_results/*"
        find . -name __pycache__ | xargs rm -rf
        find . -name __pycache__ | xargs rm -rf
        find . -name .pytest_cache | xargs rm -rf
        find . -name "*.pyc" -delete
    '''
}

return this
