#!groovy

def lib = library identifier: 'my-shared-library@master', retriever: modernSCM(github(repository: 'my-shared-library', repoOwner: 'empikls'))

def podLabel = "label2"

properties([
  parameters([
    string(name: 'dockerTag', defaultValue: '', description: 'git tag or short commit from upstream build' )
  ])
])

helmTemplate(podLabel) {
  node(podLabel){

    git credentialsId: 'gitHub',
      url: 'https://github.com/empikls/control-release.git'
    
    // list yaml pathFiles
    def yamlFilePathList = fileList('.')

    // List<SunStage>
    List stages = [] 

    yamlFilePathList.each {
        stages.add( sunClassLoad(it) )
    }

    // get filePath from changeSet 
    def stagesList = isChangeList()

    if ( isShortCommit(params.dockerTag) ) stagesList.add( 'dev/dev-web.yaml' )

    if ( isBuildingTag(params.dockerTag) ) stagesList.add( 'qa/qa-web.yaml' )

    // init stage deploy for each Sun
    stages.each { stage -> 
      stagesList.each { prod -> 
          if ( stage.stageName == prod ) 
            if ( prod == 'dev/hollychain.yaml' || prod == 'qa/emptyworld.yaml' )
              stage.initDeploy( prod, params.dockerTag ) 
            else {
              def tag = readYaml(file: prod).image.tag
              if ( isExistsGitTags(tag) ) stage.initDeploy(prod, tag)
          }
      }
    }
       
    stages.each {
        it.deployHelmStage(this,steps)
    }
  }
}  
