package flows.case3

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


suspend fun main() {
    val b = B()
    b.needed()
}

typealias SingleEvent<T> = (T) -> Unit

class A {
    private var listener: SingleEvent<Int>? = null

    fun onSelects(): Flow<Int> = channelFlow {
        repeat(100) {
            listener = { trySend(it) }
        }

        awaitClose { listener = null }
    }
}

class B {
    val a = A()

    fun needed() {
        runBlocking {
            a.onSelects()
                .filter { it % 2 == 0 }
                .transform { if (it > 10) emit(it) }
                .map {}
                .onEach { println("it = $it") }
                .collect()
        }
    }
}