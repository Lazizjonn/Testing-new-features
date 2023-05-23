package flows.case7

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


@OptIn(FlowPreview::class)
fun main() = runBlocking {

    val startTime1 = System.currentTimeMillis()
    (1..100).asFlow().onEach { delay(100) }
        .flatMapConcat { requestFlow(it) }
        .collect { value ->
            print("$value at ${System.currentTimeMillis() - startTime1} ms from start | ")
        }

    println()

    val startTime2 = System.currentTimeMillis()
    (1..100).asFlow().onEach { delay(100) }
        .flatMapMerge(1000) {
            requestFlow(it)
        }
        .collect { value ->
            print("$value at ${System.currentTimeMillis() - startTime2} ms from start | ")
        }

    val startTime3 = System.currentTimeMillis()
    (1..100).asFlow().onEach { delay(100) }
        .flatMapLatest { requestFlow(it) }
        .collect { value ->
            print("$value at ${System.currentTimeMillis() - startTime3} ms from start | ")
        }

}

fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i:First")
    delay(500)
    emit("$i: Second")
}

