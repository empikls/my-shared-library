def call(Closure code) { podTemplate(
        cloud: 'kubernetes',
        namespace: 'jenkins',
        label: 'docker-dind',
        containers: [
                containerTemplate(
                        name: 'nodejs',
                        image: 'node:latest',
                        ttyEnabled: true,
                        command: 'cat'),
                containerTemplate(
                        name: 'docker',
                        image: 'docker:19.03.3-git',
                        ttyEnabled: true,
                        command: 'cat'
                )
        ],
        volumes: [
                hostPathVolume(hostPath: '/var/lib/docker', mountPath: '/var/lib/docker')
        ]) {
    code() }
}