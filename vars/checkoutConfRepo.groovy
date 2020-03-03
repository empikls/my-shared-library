def call(String tag) {

    checkout([
              $class           : 'GitSCM',
              branches         : [[name: tag]],
              extensions       : [[$class: 'RelativeTargetDirectory', relativeTargetDir: tag]],
              userRemoteConfigs: [[credentialsId: 'gitHub', url: 'https://github.com/empikls/node.is']]])
}
