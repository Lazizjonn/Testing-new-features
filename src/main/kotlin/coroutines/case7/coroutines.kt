package coroutines.case7

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
With context and create [coroutineScope], [GlobalScope], [withContext]
 */
fun main() = runBlocking {
    val time = measureTimeMillis {

        println("Start requesting...")
        val scope = CoroutineScope(Dispatchers.Main + Job())
        val scope2 = CoroutineScope(Dispatchers.IO + SupervisorJob())
        val scope3 = CoroutineScope(Dispatchers.Default + coroutineContext)
        val scope4 = GlobalScope

        launch {
            withContext(Dispatchers.Main) {
                request(1000)
            }
            launch { }
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