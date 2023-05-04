package highorderfunc


fun main(args: Array<String>) {
//    val first = First()
//    val second = Second()
//    first.scope()
//    first.scopeExtension()
//    second.scope()
//    second.scopeExtension()
//    val third = Third()
//    third.scope { i, s ->
//        println("$i + $s")
//        return@scope Second() }
//    val d = D()
//    d.method3().invoke(10)
//    val e = E()
//    e.eMethod(String::sample).invoke("Lazizjon", 8)
//    val f = F()
//    f.scope(10) { return@scope this * this }.invoke("Laziz", 10)
//    val a = 15
//    val b = "L"
//    a.scope()
//    b.scope()

    val colors = listOf("w", "q","e")
    println(colors[2])
    println(colors.get(2))


    14.example1 {

    }

    12.example2 {
        
    }

}

//7-masala
fun <T> T.example1(block: (T) -> Unit) {
    block.invoke(this)
}

fun <T> T.example2(block: T.() -> Unit) {
    block.invoke(this)
}
//7-masala

//6-masala
fun <T> T.scope() {
    println(this)
}
//6-masala

// 5-masala
class F {
    fun scope(amount: Int, block: Int.() -> Int): (String.(Int) -> Unit) {
        println(block.invoke(amount))
        return String::sample
    }
}
// 5-masala

// 4-masala
class E {
    fun eMethod(block: String.(Int) -> Unit): (String.(Int) -> Unit) {
        block.invoke("Laziz", 5)
        return String::sample
    }
}

fun String.sample(value: Int) {
    println(this.length)
    println(value)
}
// 4-masala

// 3-masala
class D {

    fun method3(): ((Int) -> Unit) {
        println("1")
        return ::method4
    }

    private fun method4(value: Int) {
        println("2")
    }
}
// 3-masala

// 2-masala
class Third {
    fun scope(block: (Int, String) -> Second) {
        block.invoke(2, "Two")
        block.invoke(3, "Three")
    }
}
// 2-masala

// 1-masala
class First {
    fun scope() {
        println("First classdagi scop methodi ishladi")
    }
}

class Second() {

    fun scope() {
        println("Second classdagi scop methodi ishladi")
    }

    fun fast() {
        println("fast")
    }
}

fun <T> T.scopeExtension() {
    println("Extensiondagi method ishladi")
}
// 1-masala

// 0-masala
class Example<T> {
    fun exampleFun1(t: T): T {
        return t
    }
}

class Example2 {
    fun <T> exampleFun2(t: T): T {
        return t
    }
}
// 0-masala