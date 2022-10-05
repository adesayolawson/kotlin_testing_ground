import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.suspendCoroutine

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
}



suspend fun <T : Any> getValue(provider: () -> T): T =
    suspendCoroutine { continuation ->
        continuation.resumeWith(Result.runCatching { provider() })
    }

fun executeBackground(action: suspend () -> Unit) {
    GlobalScope.launch { action() }
}

fun executeMain(action: suspend () -> Unit) {
    GlobalScope.launch(context = Dispatchers.Main) { action() }
}
