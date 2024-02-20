enum class DAYS(val isWeekend: Boolean = false) {
    SUNDAY(isWeekend = true),
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY(isWeekend = true);

    companion object {
        fun today(obj: DAYS): Boolean {
            return obj.name.compareTo("SATURDAY") == 0 || obj.name.compareTo("SUNDAY") == 0
        }
    }

}
//Unlike sealed classes, enum classes can’t have subclasses, and the set of values is predetermined at compile time.
// This makes enum classes suitable for scenarios where a predefined set of options is expected, like representing days, months, or error states.

fun main() {
    // A simple demonstration of properties and methods
    for (day in DAYS.values()) {
        println("${day.ordinal} = ${day.name} and is weekend ${day.isWeekend}")
    }
    val today = DAYS.MONDAY
    println("Is today a weekend ${DAYS.today(today)}")
}