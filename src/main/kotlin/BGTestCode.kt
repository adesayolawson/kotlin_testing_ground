import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun main() {
//    val s = Scanner(System.`in`)
//    val a = s.nextInt()
//    val b = s.nextInt()
//    println(a + b)
    val rfName = "fjhfjh||jjhjhjh"
    val vh = rfName.split("||")
    println(vh)
    println(
        rfName.replace("_", " ").lowercase().split(" ")
            .joinToString(" ") { rfType -> rfType.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } })

//    (1..10000).forEach {
//        GlobalScope.launch(Dispatchers.IO) {
//            val threadName = Thread.currentThread().name
//            println("$it printed on thread $threadName")
//        }
//        Thread.sleep(10)
//    }

//    println(0 % 3)


    println(vh[1])


}

fun parseAnyDateString(dateString: String): Date? {
    val dateFormats = arrayOf(
        "yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ssZ",
        "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mm:ss",
        "MM/dd/yyyy HH:mm:ss", "MM/dd/yyyy'T'HH:mm:ss.SSS'Z'",
        "MM/dd/yyyy'T'HH:mm:ss.SSSZ", "MM/dd/yyyy'T'HH:mm:ss.SSS",
        "MM/dd/yyyy'T'HH:mm:ssZ", "MM/dd/yyyy'T'HH:mm:ss",
        "yyyy:MM:dd HH:mm:ss", "yyyy-MM-dd", "dd/MM/yyyy",
        "EEEE, MMM d, yyyy", "d MMMM yyyy", "yyyyMMdd", "yyyy/MM/dd"
    )

    for (dateFormat in dateFormats) {
        val sdf = SimpleDateFormat(dateFormat, Locale.getDefault())
        try {
            return sdf.parse(dateString)
        } catch (e: ParseException) {
            println("parse exception occurred")
        }
    }

    return null
}

fun findMaxPairwiseProduct(numbers:List<Long>):Long{
    val multipliedList = mutableListOf<Long>()
    val sortedList = numbers.sortedDescending()
    val maxNumber = sortedList[0]
    val secondMaxNumber = sortedList[1]
    numbers.forEach { num->
        val newList = numbers.map { it*num }
        multipliedList.addAll(newList)
    }
    println(multipliedList)
    return multipliedList.maxOrNull() ?: 0
}