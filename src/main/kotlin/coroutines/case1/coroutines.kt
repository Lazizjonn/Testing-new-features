package coroutines.case1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    example1()
}

/** 1.1 Difference between delay va Thread.sleep*/
fun example1() {
    log("example1: start")

    runBlocking {

        launch {
            log("example1: before delay(2000)")
            delay(2000)
            log("example1: after delay(2000)")
        }

        launch {
            log("example1: before Thread.sleep(10_000)")
            Thread.sleep(10_000)
            log("example1: after Thread.sleep(10_000)")
        }

    }

    log("example1: end")

}

fun log(msg: String) {
    val time = System.currentTimeMillis() % 100000
    println("[$time] [${Thread.currentThread().name}] $msg")
}