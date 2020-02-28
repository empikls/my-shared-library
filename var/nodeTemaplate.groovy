def call(String podLabel, Closure code) { podTemplate(
        cloud: 'kubernetes',
        namespace: 'jenkins',
        label: podLabel,
        containers: [
                containerTemplate(
                        name: 'nodejs',
                        image: 'node:latest',
                        ttyEnabled: true,
                        command: 'cat'),
                containerTemplate(
                        name: 'docker-dind',
                        image: 'docker:19.03.3-dind',
                        ttyEnabled: true,
                        privileged: true)
        ]) {
    code() }
}