package coroutines.case3

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
3.Sync 3 request total time 6550
 */
fun main() = runBlocking {
    println("Start requesting...")
    val time = measureTimeMillis {
        request(3000)
        request(2000)
        request(1500)
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