class ClassAndDataClass {

    fun setName() {
        println("name")
    }
}

data class SampleDataClass(val name: String)

//Differences between data classes and normal classes.
//A data class must be declared with at least one primary constructor parameter which must be declared with val or var. A normal class can be defined with or without a parameter in its constructor.
//Data classes have default implementations for the following methods using only properties that were declared in the primary constructor; toString(), hashCode(), copy(), componentN(), equals().
//Implementation for those methods can be written in normal classes using properties that were and were not declared in the primary constructor.
//A data class cannot be extended by another class. They are final classes by default. Normal classes can be extended by other classes, including data classes. Certain conditions should however be met.
//Data classes cannot be sealed, open, abstract or inner. Normal classes can be any of these.

//The primary constructor needs to have at least one parameter.
//All primary constructor parameters need to be marked as val or var.
//Data classes cannot be abstract, open, sealed or inner.
//Data classes may only implement interfaces.
//default methods
//equals()
//hashCode()
//toString()
//copy()
