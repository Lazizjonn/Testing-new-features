package kotlinFiles

fun main(args: Array<String>) {
    for (i in 0..10) {
        println()
    }
    for (i in 5 downTo 0) {
        println()
    }
    val arr = intArrayOf(1, 2, 3, 4, 5)
    for (i in arr) {
        println()
    }

    val arrayList = ArrayList<String>()
    arrayList.add("laziz0")
    arrayList.add("laziz1")
    arrayList.add("laziz2")
    arrayList.add("laziz3")
    println(arrayList)
}

class Fruit {
    var fruitType: String = ""

    infix fun type(mType: String): Unit {
        this.fruitType = mType
    }
}