def call(String namespace, String releaseName, String valuesFile, String imageTag) {
    sh """
            echo appVersion: $imageTag >> ${imageTag}/app/Chart.yaml
            helm upgrade --dry-run --debug \
            --install $releaseName \
            --namespace $namespace \
            --force \
            --wait \
            ${imageTag}/app \
            --values $valuesFile  \
            --set-string image.tag=$imageTag

            helm ls
    """
}