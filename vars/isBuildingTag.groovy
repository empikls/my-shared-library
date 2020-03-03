def call(String name) {
    return ( name ==~ /^\d+\.\d+\.\d+$/ || name ==~ /^\d+.\d+.\d+$/ )
}
