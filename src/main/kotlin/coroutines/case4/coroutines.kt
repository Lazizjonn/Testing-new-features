package coroutines.case4

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


/**
4.Async 3 request total time 3050
 */
fun main() = runBlocking {
    example41()
    example42()
}

/**
4.1.Async 3 request total time 3050, simple
 */
fun example41() = runBlocking {
    println("Start requesting...")
    val time = measureTimeMillis {
        val a1 = async { request(1000) }
        val a2 = async { request(2000) }
        val a3 = async { request(3000) }
        val v1 = a1.await()
        println("v1 = $v1")
        val v2 = a2.await()
        println("v2 = $v2")
        val v3 = a3.await()
        println("v3 = $v3")
    }
    println("Total time: $time")
    println("Request finished")
}


/**
4.2.Async 3 request total time 3050 with ArrayList<Deferred<Int>>()
 */
fun example42() = runBlocking {
    val list = ArrayList<Deferred<Int>>()
    println("Start requesting...")
    val time = measureTimeMillis {
        list.add(async { request(1000) })
        val a2 = async { request(2000) }
        list.add(a2)
        val a3 = async { request(3000) }
        list.add(a3)
        val sum = list.awaitAll().sum()
        println("Sum: $sum")
    }
    println("Total time: $time")
    println("Request finished")
}


/**
Server request (imaginary)
 */
suspend fun request(time: Long): Int {
    delay(time)
    return time.toInt()
}