def call(String tag) {

    checkout([$class           : 'GitSCM',
              branches         : [[name: tag]],
              extensions       : [[$class: 'RelativeTargetDirectory', relativeTargetDir: tag]],
              userRemoteConfigs: [[url: "https://github.com/empikls/node.is"]]])
}
