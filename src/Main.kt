/**
 * Это класс main - точка входа в программу
 */
fun main() {
//    Задание 2: “Hello world”
    println("Hello,world!")
    println()

//    Задание 3: Работа с переменными
    var myString = "Kotlin"
    val myChar: Char = ' '
    myString += myChar + "AQA"
    var myDouble: Double = 10.0
    myDouble /= myDouble * 0.5
    val myBoolean: Boolean = myDouble > myDouble * 0.5
    println("myString = $myString")
    println("myDouble = $myDouble")
    println("myBoolean = $myBoolean")
    println()

//    Задание 4: Работа с операторами
    var a = 10
    var b = -1
    a++
    b--
    val c = a * b
    val isPositive = c > 0
    val isGreaterOrEqual = c >= a
    val result = ( b < a ) && (a < -c)
    val result2 = ( b > 0 ) && (c > 0) || (c > a)
    val result3 = !(c > a || b > a)
    println("c = $c")
    println("isPositive = $isPositive")
    println("isGreaterOrEqual = $isGreaterOrEqual")
    println("result = $result")
    println("result2= $result2")
    println("result3 = $result3")
    println()

//    Задание 5: Комментарии и стандартный ввод/вывод
    println("Какой у вас питомец?")
    val petType = readLine().toString()
    println("Как зовут $petType?")
    val petName = readLine().toString()
    println("Сколько лет $petName?")
    val petAge = readLine().toString()
    val petInfo = petInfo(petType, petName, petAge)
    petInfo.printInfo()

}