package coroutines.case6

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlin.system.measureTimeMillis

/**
6.WithTimeOut() method
 */
fun main() = runBlocking {
    example6_1()
    example6_2()
}

/**
6.1.withTimeOut throws exception when request over set time
Exception: Exception in thread "main" kotlinx.coroutines.
TimeoutCancellationException: Timed out waiting for 2000 ms
 */
suspend fun example6_1() = runBlocking {
    val time = measureTimeMillis {

        println("Start requesting...")

        withTimeout(2000) {
            request(2001)
        }

    }
    println("Request finished")
    println("Total time: $time")
}

/**
6.1.withTimeOut seems does not throw exception, but we could not catch it.
Because it is child of another coroutine builder.
But if we write try catch we can get them
 */
suspend fun example6_2() = runBlocking {
    val time = measureTimeMillis {

        println("Start requesting...")

        launch {
            val t = withTimeout(2000) {
                request(2001)
            }
            println("time out value = $t")
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