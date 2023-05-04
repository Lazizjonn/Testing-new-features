package coroutines.case5

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
5.With launch
 */
fun main() = runBlocking {
    example5_1()
    example5_2()
}

/**
5.1.With launch
 */
suspend fun example5_1() = runBlocking {
    val time = measureTimeMillis {
        val list = ArrayList<Job>()

        println("Start requesting...")

        val job1 = launch { request(3000) }
        val job2 = launch { request(2000) }
        val job3 = launch { request(1500) }
        list.add(job1)
        list.add(job2)
        list.add(job3)

        list.joinAll()
    }
    println("Request finished")
    println("Total time: $time")
}

/**
5.2.With launch cancel job which is inside several async tasks
 */
suspend fun example5_2() = runBlocking {
    val time = measureTimeMillis {

        println("Start requesting...")

        val t = async {
            launch { request(3000) }
            launch { request(2000) }
            launch { request(1500) }
            println("Finish async")
            2
        }
        delay(200)
        t.cancel()
        t.invokeOnCompletion {
            println("FINISHED")
        }

    }
    println("Request finished")
    println("Total time: $time")
}

/**
Server request (imaginary)
 */
suspend fun request(time: Long): Int {
    delay(time)
    return time.toInt()
}