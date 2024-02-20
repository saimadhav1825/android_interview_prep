//in inline function is declare with a keyword inline.
//The use of inline function enhances the performance of higher order function.
//The inline function tells the compiler to copy parameters and functions to the call site.*/


inline fun sampleInlIneFunction(fn:()->Unit){
    fn()
    println("code inside line function")
}
fun main(){
    sampleInlIneFunction {
        println("calling inline function")
    }
}