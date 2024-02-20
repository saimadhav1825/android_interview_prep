//To define a sealed class, just precede the class modifier with the sealed keyword.
// The sealed classes also have one another distinct feature, their constructors are protected by default.
// A sealed class is implicitly abstract and hence it cannot be instantiated.

sealed class SealedClassExample {
    object Init : SealedClassExample()
    data class LoginRequest(val name: String) : SealedClassExample()
    data class LoginResponse(val name: String) : SealedClassExample()
}

sealed class AnotherSealedClass : SealedClassExample() {
   // data class LoginRequest(val name: String) : SealedClassExample()/// This will cause an error. Sealed class is not visible here
    data class AnotherLoginRequest(val name: String) : AnotherSealedClass()/// This will cause an error. Sealed class is not visible here
}

// A function to take in an object of type Fruit
// And to display an appropriate message depending on the type of Fruit
fun display(fruit: SealedClassExample) {
    when (fruit) {
        is SealedClassExample.LoginRequest -> println("${fruit.name} is good for iron")
        else -> SealedClassExample.Init
    }
}

// A function to take in an object of type Fruit
// And to display an appropriate message depending on the type of Fruit
fun display(fruit: AnotherSealedClass) {
    when (fruit) {
        is AnotherSealedClass.AnotherLoginRequest -> println("${fruit.name} is good for iron")
        else -> SealedClassExample.Init
    }
}
fun main() {
    // Objects of different subclasses created
    val obj = AnotherSealedClass.AnotherLoginRequest("LoginRequest")

    // Function called with different objects
    display(obj)
}