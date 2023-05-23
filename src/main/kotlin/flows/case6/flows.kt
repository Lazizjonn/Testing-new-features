package flows.case6

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

//    val a = countDownFlow()
//        .reduce { accumulator, value ->
//            println("Accumulator= $accumulator, value=$value")
//            accumulator
//        }
//    println("A=$a")
//
//    val b = countDownFlow()
//        .fold(100) { accumulator, value ->
//            println("Accumulator= $accumulator, value=$value")
//            accumulator
//        }
//    println("A=$a")
//    println("B=$b")

//    countDownFlow()
//        .filter { time ->
//            time % 2 == 0
//        }
//        .map { time ->
//            if (time > 0) time * 1.2
//            else time * 1.1
//        }
//        .onEach { time ->
//            time * 1.2
//        }
//        .onEach { time ->
//            // foydalanamiz, lekin o'zgartirolmaymiz, yana emit qilolmaymiz, tepadagilarni hammasida
//        }
//        .transform { time ->
//            if (time == 0.0) {
//                emit("String")
//            }
//        }
//        .collect { time ->
//            println(time)
//        }

//
//    // 10 keyin 0 chiqadi o'rtadagilarni skip qiladi
//    countDownFlow()
//        .collectLatest { time ->
//            delay(1001)
//            println(time)
//        }
}

fun countDownFlow(): Flow<Int> = flow {
    val startingValue = 10
    var currentValue = startingValue

    emit(startingValue)

    while (currentValue > 0) {
        delay(1000)
        currentValue--
        emit(currentValue)
    }
}