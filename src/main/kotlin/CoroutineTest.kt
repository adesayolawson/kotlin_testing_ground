import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {
//    (1..10000).forEach {
//        val v = GlobalScope.launch(Dispatchers.IO, start = CoroutineStart.LAZY) {
//            val threadName = Thread.currentThread().name
//            println("$it printed on thread $threadName")
//        }
//        Thread.sleep(10)
//
//    }

    with(GlobalScope) {
        val parentJob = launch {
            delay(200)
            println("I’m the parent")
            delay(200)
        }
        launch(context = parentJob) {
            delay(200)
            println("I’m a child")
            delay(200)
        }
        if (parentJob.children.iterator().hasNext()) {
            println("The Job has children ${parentJob.children}")
        } else {
            println("The Job has NO children")
        }
        Thread.sleep(1000)


    }
    fun testFun(){
        thread {
            
        }
    }
}
