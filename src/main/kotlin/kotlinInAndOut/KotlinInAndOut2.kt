package kotlinInAndOut

fun main() {
    /*
    Producer -> returns some values => out ;
    Consumer -> consumes some values => in ;

    Producer: => [Android, Ios]
    List<? extends Phone> list = [Android, Ios] -> in Java

    Consumer
    List <? super Android> list = Phone -> in Java
    * */

    val producerPhone: ProducerPhone<Phone> = ProducerPhone<Android>(Android())
    producerPhone.get().printOs()
    val consumerPhone: ConsumerPhone<Ios> = ConsumerPhone<Phone>()
    consumerPhone.printPhone(Ios())
}

open class Phone(val os: String) {
    fun printOs() {
        println("Os is $os")
    }
}

class Android : Phone("Android")
class Ios : Phone("Ios")

class ProducerPhone<out T>(val phone: T) {
    fun get(): T {
        return phone
    }
}

class ConsumerPhone<in T> {
    fun printPhone(phone: T) {
        println(phone.toString())
    }
}