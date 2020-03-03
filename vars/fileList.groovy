def call(String path){

    return sh(returnStdout: true, script: "find $path -name *.yaml")
            .readLines().sort().collect{ it.substring( path.length()+1 )}
}