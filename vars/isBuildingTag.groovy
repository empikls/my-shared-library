def call(String name) {
    return (name ==~ /^v\d+.\d+.\d+$/ || name ==~ /^\d+.\d+.\d+$/)
}
