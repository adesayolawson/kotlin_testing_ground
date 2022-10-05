import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


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

    val v = listOf(".x", ".y", ".z").joinToString('\n'.toString())
    val regex = "^100(\\.0{0,2})? *%?\$|^\\d{1,2}(\\.\\d{1,2})? *%?\$".toRegex()
    val version = "10.23".matches(regex)
    val secret = "CollectionCenter"
    val testValue = "24".toFloatOrNull()
    val range = (1..10000).chunked(100)
    val jk = Calendar.getInstance().before("2023-10-10 00:00:00")
    println(range)


    val test = "IK00009853_200401075909_m,4281,T-1000000000008091,T-1000000000008191".encrypt()
    println(test)
    val testDecoded = test.decrypt()
    println(testDecoded)

    val vv = listOf("1","2","3","4")




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

fun findMaxPairwiseProduct(numbers: List<Long>): Long {
    val multipliedList = mutableListOf<Long>()
    val sortedList = numbers.sortedDescending()
    val maxNumber = sortedList[0]
    val secondMaxNumber = sortedList[1]
    numbers.forEach { num ->
        val newList = numbers.map { it * num }
        multipliedList.addAll(newList)
    }
    println(multipliedList)
    return multipliedList.maxOrNull() ?: 0
}

fun String.encrypt(): String {
    val secret = "babbanGona123456"
    val secretIV = "1234567890123457"
    val iv = IvParameterSpec(secretIV.toByteArray())
    val keySpec = SecretKeySpec(secret.toByteArray(), "AES")
    val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv)
    val crypted = cipher.doFinal(this.toByteArray())
    val encoder = Base64.getEncoder()
    val encodedByte = encoder.encode(crypted)
    return String(encodedByte)
}


fun String.decrypt(): String {
    val secret = "babbanGona123456"
    val secretIV = "1234567890123457"
    val decoder = Base64.getDecoder()
    val decodedByte: ByteArray = decoder.decode(this)
    val iv = IvParameterSpec(secretIV.toByteArray())
    val keySpec = SecretKeySpec(secret.toByteArray(), "AES")
    val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
    cipher.init(Cipher.DECRYPT_MODE, keySpec, iv)
    val output = cipher.doFinal(decodedByte)
    return String(output)
}

fun test(){

}
