class NullCheckSample {
   // private val name: String = null it will through error if wee do like this not compile
    private val name: String? = null
    init {
        println(name)
    }
    var names: String = "defaultvalue"
        get() = field                     // getter
        set(value) { field = value }      // setter

}

fun main(args: Array<String>) {
    // variable is declared as nullable
    var s2: String? = "GeeksforGeeks"

    s2 = null    // no compiler error

    //println(s2.length)  // compiler error because string can be null
}
//Not null assertion : !! Operator
//The not null assertion (!!) operator converts any value to a non-null type and throws an exception if the value is null.
//If anyone want NullPointerException then he can ask explicitly using this operator.