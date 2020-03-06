#!groovy
List call() {
    def gettags
    sshagent(credentials: ['git_ssh']) {
        sh 'ps aux'
        env.GIT_SSH_COMMAND = "ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no"
        gettags = sh(returnStdout: true, script: 'git ls-remote -t git@github.com:empikls/node.is.git')
    }
    return gettags.readLines()
            .collect { it.split()[1].replaceAll('refs/tags/', '') }
}