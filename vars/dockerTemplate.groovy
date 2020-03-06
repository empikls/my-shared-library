def call(Closure code) { podTemplate(
        cloud: 'kubernetes',
        namespace: 'jenkins',
        label: 'worker',
        containers: [
                containerTemplate(
                        name: 'nodejs',
                        image: 'node:latest',
                        ttyEnabled: true,
                        command: 'cat'),
                containerTemplate(
                        name: 'docker-dind',
                        image: 'docker',
                        ttyEnabled: true,
                        command: 'cat'
                )
        ],
        volumes: [
                hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')
        ]) {
    code() }
}