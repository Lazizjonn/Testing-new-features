package coroutines.case2

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// ---------- simple logger with time + thread ----------

private val startTime = System.currentTimeMillis()

fun log(msg: String) {
    val elapsed = System.currentTimeMillis() - startTime
    println("[${elapsed.toString().padStart(5)} ms] [${Thread.currentThread().name}] $msg")
}

// ---------- fake data sources ----------

suspend fun remoteFetch(): String {
    log("remoteFetch(): start (network call, 3000 ms)")
    delay(3000)
    log("remoteFetch(): end, returning REMOTE_DATA")
    return "REMOTE_DATA"
}

suspend fun localFetch(): String {
    log("localFetch(): start (local DB/cache, 1000 ms)")
    delay(1000)
    log("localFetch(): end, returning LOCAL_DATA")
    return "LOCAL_DATA"
}

// ---------- examples ----------

fun main() = runBlocking {
    log("main: start")

    println()

    log("----- SEQUENTIAL EXAMPLE -----")
    sequentialLoad()

    println()

    log("----- PARALLEL (ASYNC) EXAMPLE -----")
    parallelLoadWithAsync()

    println()

    log("main: end")
}

/**
 * 1) SEQUENTIAL
 *    remoteFetch() runs fully, THEN localFetch() runs.
 *    Total time ≈ 3000 + 1000 = 4000 ms
 */
suspend fun sequentialLoad() {
    log("sequentialLoad(): start")

    val remote = remoteFetch()      // waits ~3000 ms
    val local = localFetch()        // waits ~1000 ms AFTER remote

    log("sequentialLoad(): both ready -> remote=$remote, local=$local")
    log("sequentialLoad(): end")
}

/**
 * 2) PARALLEL with async
 *
 *    remoteFetch() and localFetch() start ALMOST at the same time.
 *    Total time ≈ max(3000, 1000) = 3000 ms (instead of 4000)
 */
suspend fun parallelLoadWithAsync() = coroutineScope {
    log("parallelLoadWithAsync(): start")

    // Start BOTH operations in parallel
    val remoteDeferred = async {
        remoteFetch()
    }

    val localDeferred = async {
        localFetch()
    }

    log("parallelLoadWithAsync(): started remoteFetch() and localFetch(), doing other work...")

    // Simulate some work in main coroutine while others are running
    delay(500)
    log("parallelLoadWithAsync(): still in main, waiting for results now")

    // Wait for results (this suspends until each one finishes)
    val remote = remoteDeferred.await()
    val local = localDeferred.await()

    log("parallelLoadWithAsync(): both ready -> remote=$remote, local=$local")
    log("parallelLoadWithAsync(): end")
}
