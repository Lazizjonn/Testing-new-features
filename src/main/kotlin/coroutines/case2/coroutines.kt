package coroutines.case2

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    example2_1()
    example2_2()
}

/**
2.1.Async example
 */
suspend fun example2_1() = runBlocking {
    val deferred = async {
        println("Async is running")
        delay(2000)
        println("Async finished")
        1f
    }

    println("Hi main")
    val result = deferred.await()
    println("result: $result")
}

/**
2.1 Async example 2
 */
suspend fun example2_2() = runBlocking {
    val deferred = async {
        println("Async is running")
        delay(7000)
        println("Async finished")
        1f
    }

    println("Hi main start waiting...")
    delay(5000)
    println("Hi main finished waiting...")

    val result = deferred.await()
    println("result: $result")
}