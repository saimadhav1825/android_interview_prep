//Let Function
//Object reference   ->it
//Return value  ->Lambda result

fun letFunctionSample() {
    val name: String? = null
    val letSample = name?.let {
        println(it)
    }
    println(letSample)
}

//run Function
//Object reference   ->this
//Return value  ->Lambda result
fun runFunctionSample() {
    val name = null
    val runSample = name.run {
        println(this)

    }
    println(runSample)
}

//with Function
//Object reference   ->this
//Return value  ->Lambda result
fun withFunctionSample() {
    val sampleDataClass = SampleData()
    val withSample = with(sampleDataClass) {
        name = "withFunctionSample"
        "$name"
    }
    println(withSample)
}
//with Function
//Object reference   ->this
//Return value  ->context object

fun applyFunctionSample() {
    val sampleDataClass = SampleData().apply {
        name = "applyFunctionSample"
    }
    println(sampleDataClass)
}

//with Function
//Object reference   ->it
//Return value  ->context object
fun alsoFunctionSample() {
    val sampleDataClass = SampleData().apply {
        this.name = "applyFunctionSample"
    }.also {
        it.name = "alsoFunctionSample"
    }
    println(sampleDataClass)
}


data class SampleData(
    var name: String? = null
)

fun main() {
    alsoFunctionSample()
}
