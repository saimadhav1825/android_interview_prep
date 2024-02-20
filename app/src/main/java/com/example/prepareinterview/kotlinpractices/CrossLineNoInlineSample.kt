inline fun noInlineSample(fn: () -> Unit, noinline fnOne: () -> Unit) {
    fn.invoke()
    fnOne.invoke()
}

inline fun CrossLineSample(crossinline fnOne: () -> Unit) {
    fnOne.invoke()
}


fun main() {
  /*  noInlineSample({
        println("function")
    }) {
        println("functionOne")
    }*/
    println("before cross line")
    CrossLineSample {
        println("functionOne")
        //'return' is not allowed here
        //return
    }
    println("after cross line")

}