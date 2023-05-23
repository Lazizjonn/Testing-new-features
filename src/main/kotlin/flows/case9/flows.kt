package flows.case9

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow


suspend fun main() {
    val vm = VM()
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    vm.squareNumber(4)

    scope.launch {
        vm.sharedFlow.collect {
            delay(2000L)
            println("First flow: The received number is $it")
        }
    }

    scope.launch {
        vm.sharedFlow.collect {
            delay(4000L)
            println("Second flow: The received number is $it")
        }
    }

    repeat(10) {
        vm.incrementCounter()
        delay(1000)
        println("value = ${vm.stateFlow.value}")
    }

}


class VM {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<Int>(5)
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        scope.launch {
            sharedFlow.collect {
                delay(2000L)
                println("First flow: The received number is $it")
            }
        }

        scope.launch {
            sharedFlow.collect {
                delay(3000L)
                println("Second flow: The received number is $it")
            }
        }
    }

    fun incrementCounter() {
        _stateFlow.value += 1
    }

    suspend fun squareNumber(number: Int) {
        _sharedFlow.emit(number * number)
    }
}
