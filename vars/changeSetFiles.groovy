def call() {
    def listFilePath = []
    currentBuild.changeSets.each { changeSet ->
        changeSet.items.each { entry ->
            entry.affectedFiles.each { file ->
                if ( file.path ==~ /^prod-(ap1|eu1|us1|us2)\/\w+.yaml$/ ) listFilePath.add(file.path)
            }
        }
    }
    return listFilePath.unique()
}