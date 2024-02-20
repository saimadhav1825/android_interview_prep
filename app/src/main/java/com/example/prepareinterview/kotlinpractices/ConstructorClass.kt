class ConstructorClass(primaryConstructor: String) {

    val name: String = ""

    init {
        println(name)
    }

    init {
        println("first")
    }

    init {
        println("second")
    }

    init {
        println("third")
    }
}

class SecondaryConstructorClass() {

    //secondary constructor
    val name: String = ""

    constructor(name: String) : this() {

    }

    constructor(name: String, type: String) : this(name) {

    }

    init {
        println(name)
    }

    init {
        println("first")
    }

    init {
        println("second")
    }

    init {
        println("third")
    }
}