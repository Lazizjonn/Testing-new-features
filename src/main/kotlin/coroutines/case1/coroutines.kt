package coroutines.case1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    example1()
    example2()
}

/** 1.1 Difference between delay va Thread.sleep*/
suspend fun example1() {
    delay(1000)
    Thread.sleep(1000)
}

/**
1.2.Coroutine delay
 */
suspend fun example2() {
    println("1")
    delay(1000)
    println("2")

    val a = coroutineScope {
        delay(2000)
        "3"
    }
    println(a)
}