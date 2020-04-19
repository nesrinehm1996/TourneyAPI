//pipeline{
//agent any 
  //environment{
   // PATH = "\Program Files (x86)\apache-maven-3.6.3\bin:$PATH"
  //}
 // stages{
   // stage("Git Checkout"){
     // steps{
       //    git credentialsId: 'nexus-credentials' , url: 'https://github.com/nesrinehm1996/TourneyAPI'      
     // }
    //}
    //stage("Maven Build"){
      //steps{
        //sh "mvn clean package"
      //}
    //}
  //}
//}

node{
  stage('SCM Checkout'){
    
   // git 'https://github.com/nesrinehm1996/TourneyAPI'
    git credentialsId: 'nexus-credentials' , url: 'https://github.com/nesrinehm1996/TourneyAPI'
  }
  stage('Compile-package'){
    def mvnHome = tool name: 'maven3', type: 'maven'
    //sh "${mvnHome}/bin/mvn"
sh "mvn clean package"
  }
}
