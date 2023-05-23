package scopes.case2

fun main() {
    val a = A()
    a.first(10)

    val ab = a.scope(
        block = { return@scope it.toString() },
        abs = "Lazizjon"
    )
    println(ab)
}

class A {
    fun first(a: Int): Int {
        val a = a * a
        return a
    }

    fun scope(block: String.(Int) -> String, abs: String) : String {
        println(block.invoke("20", 10))
        println(abs)
        return abs
    }
}