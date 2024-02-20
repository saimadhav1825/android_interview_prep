class ConstructorTypes constructor(name: String) {
    init {
        println("Initial")
        println(name)
    }

    constructor(name: String, value: String = "value") : this(name) {
        println(name)
        println(value)
    }

    companion object {
        const val SAMPLE = "ConstructorTypes"
    }
}

class PrimaryConstructor(val name: String, val value: String) {
    init {
        println(name)
    }

    constructor(name: String) : this(name, "") {
        println("This is primary constructor")
    }
    constructor(name: Int) : this("name", "") {

    }
    init {
        println("This is first init block")
    }
    init {
        println("This is second init block")
    }
    init {
        println("This is third init block")
    }

}
