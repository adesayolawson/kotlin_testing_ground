import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
    val l1 = listOf(1, 2, 3)
    val s1 = "rf_yam,rf_beans,rf_days"
    val s2 = s1.dropLast(1)
    val l7 = s1.trim().split(" ")
    val i2 = l7.size
    val l8 = mutableListOf<String>()
    l7.forEach {
        val v1 = it.take(1)
        l8.add(v1)
    }
    val s7 = l8.joinToString(separator = "").uppercase()
    val s3 = "4"
    val s5 = "joy"
    val s6 = s1.split( ",")
    val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    val l9 = mutableListOf<Int>()
    "1.2.788-DEBUG".dropLastWhile { !it.toString().matches(regex) }.split('.').forEach {
        l9.add(it.toInt())
    }

    val networkResponse:String? = null
    try {
        val list = networkResponse!!.toList()
    }catch (e:NullPointerException){
        println("Network response is null")
    }

    if(!networkResponse.isNullOrBlank()){
        val list = networkResponse.toList()
    }else{
        println("Network response is null")
    }


    val sdfFormat = "dd-MM-yyyy"
    val sdf = SimpleDateFormat(sdfFormat, Locale.getDefault())
    val dateStr = "01-05-2022"
    val curDate = Date()
    val curDateStr = sdf.format(curDate)
    val dateInLong = sdf.parse(curDateStr).time
    val checkVal = curDate.time
    val long1 = Date().time
    val long2 = (long1 - 172800000L)
    val seconds = (long1 - long2) / 86400000
    val l4 = listOf((4 to 1), (2 to 5))
    val p1 = (1 to 4)
    val l5 = listOf(listOf(1, 2, 3), listOf(2, 4, 5))

    var content = ""
    content.plus(2)
    l1.forEach {
        val v = "$it||"
        content += v
    }

    val functionA = fun (word:String):List<Char>{
        return word.toList()
    }

    fun functionB(functionA: (String)->List<Char>, string: String):Boolean{
        val list = functionA(string)
        return list.size < 4
    }

    val result = functionB(functionA = functionA,"ten")

    println(result)

    println(s6)
    println(2-13)

    fun Int.isLarger (number:Int):Boolean{
       return !(((this-number)<0) || (this<number))
    }
    val i1 = 17
    println((i1.isLarger(13)))

    val testClass1 = TestClass(name = "adesayo", age = "21", date_of_birth = "20/01/1996",false)
    val testClass2 = TestClass(name = "adesayo", age = "21", date_of_birth = "20/01/1996",true)
//    println(testClass1 == testClass2)

    val toyotaCorolla = Car(color = "Blue", name = "toyota Corolla")
    println(toyotaCorolla.color)
    toyotaCorolla.drive(10)
    println(toyotaCorolla.speed)
    toyotaCorolla.park()
    println(toyotaCorolla.speed)
}

data class TestClass(
    val name: String, val age: String, val date_of_birth: String, val isMature: Boolean
) {
    override fun equals(other: Any?): Boolean {
        return try {
            val sampleTestClass = other as TestClass
            (sampleTestClass.name == this.name) && (sampleTestClass.age == this.age) && (sampleTestClass.date_of_birth == this.date_of_birth)
        } catch (e: Exception) {
            false
        }
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age.hashCode()
        result = 31 * result + date_of_birth.hashCode()
        result = 31 * result + isMature.hashCode()
        return result
    }
}

class Car(val color:String, var speed:Int =0, val name:String){

    fun drive(speedYouWant:Int){
        this.speed = speedYouWant
    }
    fun park(){
        this.speed = 0
    }
}

