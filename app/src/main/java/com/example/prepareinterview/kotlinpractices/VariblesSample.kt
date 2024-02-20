class VariablesSample {
    //The difference between var and val is that variables declared with the var keyword can be changed/modified, while val variables cannot.
    private val name = "name"
    var names = ""
    companion object{
        private const val s=""
    }

     fun sampleName() {
        println(name)
        println(names)
        println(s)
    }

}