fun main() {

    /**
     * Задание 1
     * Вам дан код: val a: String? = null. Каковы способы, которыми вы можете обратиться к a без вызова исключения NullPointerException?
     */

    val a: String? = null

    //1 - безопасный вызов
    var length = a?.length

    //2 - элвис оператор
    length = a?.length ?: 0

    //3 - конструкция if - else (или просто if)
    length = if (a != null) a.length else 0

    /**
     * Задание 2
     * Что будет выведено в результате выполнения этого кода? Почему
     */

    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> =
        nullableList.filterNotNull() // выведет [1, 2, 4] (отфильтровали не null значения)
    println(intList)

    /**
     * Задание 3
     * Вам дан код: var s: String? = null. Преобразуйте его в ненулевое значение с помощью оператора elvis, чтобы вместо null было значение "empty".
     */

    val s: String? = null
    val sNotNull: String = s ?: "Empty"
    println(sNotNull)

    /**
     * Задание 4
     * Создайте функцию, которая принимает nullable параметр и использует оператор !! для преобразования его в ненулевое значение. Что произойдет, если вы вызовете эту функцию с null?
     */

    fun printLength(s: String?) {
        println(s!!.length)
    }

    printLength(null) // вызывается исключение NullPointerException

    /**
     * Задание 5
     * Создайте пользовательское исключение InvalidUserInputException, которое выбрасывается, когда пользователь вводит что-то неверное. Покажите, как его можно перехватить и обработать.
     */

    class InvalidStringInputException() : Exception() {
        override val message = "Введено пустое значение"
        fun moreInfo() {
            println("Нужно ввести непустую строку")
        }
    }


    val inputString: String = readlnOrNull().toString()
    try {
        if (inputString.isEmpty()) {
            throw InvalidStringInputException()
        }
    } catch (e: InvalidStringInputException) {
        e.printStackTrace()
        e.moreInfo()
    } finally {
        println(inputString)
    }

}
