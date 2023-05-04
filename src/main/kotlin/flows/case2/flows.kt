package flows.case2

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

/**
 * CallBack flow
 * */
suspend fun main() {

    runBlocking {
        example()
            .onEach { println(it) }
            .collect {
                println(it)
            }
    }
}

fun example(): Flow<String> = callbackFlow {
    var manager: DownloadManager? = DownloadManager()

    manager?.onProgress {

        channel.trySend("it = $it")
    }

    manager?.onSuccess {
        channel.close()
    }

    awaitClose { manager = null }
}

class DownloadManager() {
    var a  = 0
    suspend fun onProgress(action: (Int) -> Unit) {
        repeat(100) {
            delay(100)
            action(it)
        }
    }

    fun onSuccess(action: () -> Unit) {
       action.invoke()
    }
}

class DownloadManager2(val url: String) {
    private var job: Job? = null
    private var lastPercentage = 0

    fun start(): Flow<Int> = flow {
        coroutineScope {
            job = launch {
                download {
                    emit(it)
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    fun pause() {
        job?.cancel()
    }

    fun resume() {

    }

    private suspend fun download(action: suspend (Int) -> Unit) {
        repeat(100) {
            delay(100)
            action(it)
        }
    }

}