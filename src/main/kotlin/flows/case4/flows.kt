package flows.case4

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect

suspend fun main() = callbackFlow<Unit> {
    val viewModelScope = CoroutineScope(Dispatchers.IO)

    lateinit var updater: (Int) -> Unit

    timer(
        viewModelScope,
        1,
        {
            if (it == 5) updater(1)
            println(it)
        },
        { updater = it }
    )

    awaitClose()

}.collect()

fun timer(scope: CoroutineScope, startValue: Int, ticker: (Int) -> Unit, update: ((Int) -> Unit) -> Unit): Job {
    var tick = startValue

    update {
        tick = it
    }

    return scope.launch {
        while (true) {
            delay(1000)
            ticker(tick++)
        }
    }
}