package scopes.case1

fun main() {
    val student = Student("Lazizjon")
    with(student) {
        println(age)
        println(name)
        println(surname)
        println(course)
    }.also {
        println("tugadi")
    }

    val choTakoe = student.myLet {
        println(it.age)
        B()
    }
}

class B {

}

class Student(var name: String) {
    var age: Int = 0
    var surname: String = "First initializer"
    var course: Course = Course.FIRST

    constructor(age: Int, name: String, surname: String, course: Course) : this(name) {
        this.age = age
        this.surname = surname
        this.course = course
    }

    constructor(age: Int, name: String) : this("name") {
        this.age = age
        this.name = name
    }

    fun myGetName(): String {
        return name
    }

}

enum class Course {
    FIRST, SECOND, THIRD, FOURTH
}

/**
 *  public inline fun <T, R> T.let(block: (T) -> R): R {
 *     contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
 *     return block(this)
 *  }
 **/
inline fun <T, R> T.myLet(block: (T) -> R): R {
    return block(this)
}

/**
 * public inline fun <T> T.also(block: (T) -> Unit): T {
 *     contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
 *     block(this)
 *     return this
 * }
 **/
inline fun <T> T.myAlso(block: (T) -> Unit): T {
    block(this)
    return this
}

/**
 * public inline fun <T> T.apply(block: T.() -> Unit): T {
 *     contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
 *     block()
 *     return this
 * }
 **/
inline fun <T> T.myApply(block: T.() -> Unit): T {
    block()
    return this
}

/**
 * public inline fun <T, R> T.run(block: T.() -> R): R {
 *     contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
 *     return block()
 * }
 **/
inline fun <T, R> T.myRun(block: T.() -> R): R {
    return block()
}

/**
 * public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
 *     contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
 *     return receiver.block()
 * }
 **/
inline fun <T, R> myWith(receiver: T, block: T.() -> R): R {
    return receiver.block()
}