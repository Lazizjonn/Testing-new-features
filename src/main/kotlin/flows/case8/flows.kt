@file:Suppress("UNUSED_EXPRESSION")

package flows.case8

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {

    orderFood()
        .onEach { println("$it is delivered") }
        .collect {
            println("Started eating : $it")
            delay(1000)
            println("Finished eating : $it")
        }

    orderFood()
        .onEach { println("$it is delivered") }
        .buffer()
        .collect {
            println("Started eating : $it")
            delay(1000)
            println("Finished eating : $it")
        }

    orderFood()
        .onEach { println("$it is delivered") }
        .conflate()
        .onEach {
            println("Started eating : $it")
            delay(1000)
            println("Finished eating : $it")
        }.launchIn(this)

    orderFood()
        .onEach { println("$it is delivered") }
        .onEach {
            println("Started eating : $it")
            delay(1000)
            println("Finished eating : $it")
        }.collect()
}

fun orderFood(): Flow<String> = flow {
    emit("First")
    delay(500)
    emit("Second")
    delay(500)
    emit("Third")
    delay(500)
    emit("Fourth")
    delay(500)
    emit("Fifth")
}

