boolean call(tag) {
    return tag in sh(returnStdout: true, script: 'git ls-remote -t https://github.com/empikls/node.is')
            .readLines().collect { it.split()[1].replaceAll('refs/tags/', '') }
}