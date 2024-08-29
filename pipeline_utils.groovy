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

return this
