package kotlinInAndOut

fun main() {}

interface Comparable<in T> {
    fun compare(other: T): Int
}

fun doSomething(comparable: Comparable<Number>) {
    val x: Comparable<Int> = comparable
}

fun doSomething1(comparable: Comparable<Number>) {
    val x: Comparable<Double> = comparable
}