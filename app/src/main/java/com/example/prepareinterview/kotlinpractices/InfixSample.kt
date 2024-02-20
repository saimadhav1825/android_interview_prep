fun sampleInfix() {
  val x=10
    val y=20;
    println(x xGreaterOf(5))
}

infix fun Int.xGreaterOf(value: Int): Int {
    return if (this > value) {
        this
    } else {
        value
    }
}