package flows.case5

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.runBlocking


fun main() {

}

class A {
    private val flow1: Flow<Int> = MutableSharedFlow<Int>()

    private val flow2: Flow<Int> = MutableStateFlow<Int>(0)

    fun myFlow() = channelFlow<Int> {
        runBlocking {
            flow1
        }
    }
}