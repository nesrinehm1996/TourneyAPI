node{
  stage('SCM Checkout'){
    git 'https://github.com/twanbeeren/TourneyAPI'
  }
  stage('Compile-package'){
    sh 'mvn-package'
  }
}
