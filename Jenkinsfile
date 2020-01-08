node{
  stage('SCM Checkout'){
    
    git 'https://github.com/twanbeeren/TourneyAPI'
  }
  stage('Compile-package'){
    def mvnHome = tool name: 'M3', type: 'maven'
    sh "${mvnHome}/bin/mvn"
  }
}
