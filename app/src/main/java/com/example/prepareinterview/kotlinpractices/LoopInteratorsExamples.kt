class LoopInteratorsExamples {

    fun loops() {
        for (i in 1..10) {
            if (i==9) break
            println(i)
        }
        myloop@ for (i in 1..10) {
            if (i==9) break@myloop
            println(i)
        }
        var i=0;
        while (i<=10){
            i++
            println(i)
        }
        var doI = 0;
        do {
            println("do")
            doI++
        } while (doI < 5)
    }
}