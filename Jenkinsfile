node{
  stage('SCM Checkout'){
    
    git 'https://github.com/nesrinehm1996/TourneyAPI'
  }
  stage('Compile-package'){
    def mvnHome = tool name: 'maven3', type: 'maven'
    sh "${mvnHome}/bin/mvn"
  }
}
