package kotlinInAndOut

fun main(args: Array<String>) {
    lateinit var a: Box<LegoKit>
    lateinit var b: Box<TechnoLegoKit>
//     a = b
//     b = a
}

open class LegoKit
open class TechnoLegoKit : LegoKit()
open class RoboticsLegoKit : LegoKit()

abstract class Box<T> {
    abstract fun add(something: T)
    abstract fun getStuff(): T
}

/*
abstract class Box<in T> {
    abstract fun add(something: T)
//    abstract fun getStuff(): T
}

abstract class Box<out T> {
//  abstract fun add(something: T)
    abstract fun getStuff(): T
}
*/



