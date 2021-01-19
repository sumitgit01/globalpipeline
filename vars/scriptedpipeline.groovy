def call (Map pipelineparam)
{env.REPO_NAME = pipelineparam.REPO_NAME
 env.BRANCH = pipelineparam.BRANCH
 pipeline
 {
 node 
   {
   stage ( "checkout-scm")
     {
       sh '''
       git clone $REPO_NAME
       cd nodeapp_repo
       git checkout $BRANCH
       '''
     }
     stage ( "build" )
     {
       sh '''
       cd nodeapp_repo
       npm install
       '''
     }
     stage ( "static code analysis using ESLINT or SONAR" )
     {
     }
     stage ( "upload artifacts into Nexus" )
     {}
     stage ( "deployment in QA environement" )
     {}
     stage ( "testinf in QA environement using Protractor" )
     {}
     stage ( "deploy to staging environment" )
     {}
     stage ("deploy to UAT environment" )
     {}
     stage ("deploy to production environment" )
     {}
   }
   
 }
}
