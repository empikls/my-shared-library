boolean call(String name) {
    return ( name ==~ /[a-z0-9]{7}/ )
}