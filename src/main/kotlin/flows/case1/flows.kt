package flows.case1

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*


suspend fun main() = callbackFlow<Unit> {

    val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    coroutineScope.launch {
        request()
            .onEach { println("int = $it") }
            .collect()
    }

    request()
        .onEach { println("int = $it") }
        .launchIn(coroutineScope)

    request()
        .onEach { println("int = $it") }
        .runIn(coroutineScope)

    coroutineScope.launch {
        request2 {
            println("int = $it")
        }
    }

    awaitClose()

}.collect()


fun request(): Flow<Int> = flow {
    delay(1000)
    emit(1)
    delay(1000)
    emit(2)
    delay(1000)
    emit(3)
}

suspend fun request2(emit: (Int) -> Unit) {
    delay(1000)
    emit(1)
    delay(1000)
    emit(2)
    delay(1000)
    emit(3)
}


/**
 *We are creating our runIn scope same as:
 *
 *public fun <T> Flow<T>.launchIn(scope: CoroutineScope): Job = scope.launch {
 *collect() // tail-call
}
 */
public fun <T> Flow<T>.runIn(coroutineScope: CoroutineScope) = coroutineScope.launch {
    collect()
}