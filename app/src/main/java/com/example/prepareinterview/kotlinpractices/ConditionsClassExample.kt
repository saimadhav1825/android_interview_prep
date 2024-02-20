class ConditionsClassExample {

    fun ifElse() {
        val a = 5
        val b = 3

        val c = if (a > b) {
            b
        } else a
        println(c)
    }

    fun whenCondition() {
        val x = 0;
        when (x) {
            0, 10 -> println(x)
            1 -> println(x)
            2 -> println(x)
            else -> println(x)
        }
        val y = 0
        val s = when (y) {
            in 0..10 -> y + 1
            1 -> y + 1
            2 -> y + 1
            else -> y + 1
        }
        println(s)
    }

    fun whileLoopSample() {
        var i = 0;
        while (i <= 5) {
            i++
            println(i)
        }
    }

    fun doWhileLoopSample() {
        var i = 0;
        do {
            i++
            println(i)
        } while (i <= 5)
    }

}