class MainClass {
    var name: String = ""

    class nestedClass {
        var nameof: String = "nestedClass"
        fun nestMethod() {
            println(nameof)
        }
    }
}

class MainClassOf {
    var name: String = "MainClassOf"

    inner class innerClass {
        var nameof: String = "innerClass"
        fun innerMethod() {
            println(name)
            println(nameof)
        }
    }
}

class SetterAndGetter {
    var pairOf: String = ""
        get() = field
        set(value) {
            field = value
        }
}

