def call(Closure code) { podTemplate(
        cloud: 'kubernetes',
        namespace: 'jenkins',
        label: 'worker-docker',
        containers: [
                containerTemplate(
                        name: 'nodejs',
                        image: 'node:latest',
                        ttyEnabled: true,
                        command: 'cat'),
                containerTemplate(
                        name: 'docker-dind',
                        image: 'docker:stable-dind',
                        ttyEnabled: true,
                        command: 'cat'
                )
        ],
        volumes: [
                hostPathVolume(hostPath: '/var/lib/docker.sock', mountPath: '/var/lib/docker.sock')
        ]) {
    code() }
}