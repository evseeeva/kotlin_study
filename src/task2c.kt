fun main() {

    /**
     * Задание 1: Создайте функцию maxOfTwo, которая принимает два числа в качестве аргументов и возвращает наибольшее число.
     * Затем, используйте эту функцию для поиска максимального числа из двух разных пар чисел.
     */
    val a = 1
    val b = 8
    val c = -7
    val d = 5
    fun maxOfTwo(a: Int, b: Int): Int {
        if (a > b)
            return a
        else return b
    }
    println(maxOfTwo(maxOfTwo(a, b), (maxOfTwo(c, d))))

    /**
     * Задание 2: Создайте функцию sayHello, которая принимает строковый аргумент name и возвращает приветственное сообщение.
     * Функция должна иметь параметр по умолчанию "мир". Затем вызовите функцию дважды: с именем и без имени.
     */
    fun sayHello(name: String = "мир") {
        println("Привет, $name!")
    }
    sayHello()
    sayHello("Настя")
    infix fun Int.isGreater(other: Int): Boolean {
       return this > other
    }

    /**
     * Задание 3: Создайте инфиксную функцию isGreater , которая принимает два числа и возвращает true, если первое число больше второго,
     * и false в противном случае. Затем используйте эту функцию, сравнив две пары чисел.
     */
    var max = Int.MIN_VALUE
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    if (a isGreater b) {
        max1 = a
    } else {
        max1 = b
    }
    if (c isGreater d) {
        max2 = c
    } else {
        max2 = d
    }
    if (max1 isGreater max2) {
        max = max1
    } else {
        max = max2
    }
    println(max)

    /**
     * Задание 4: Создайте рекурсивную функцию generateSequence,которая принимает целое число n и генерирует последовательность чисел от 1 до n.
     * Используйте аннотацию tailrec для оптимизации.
     */
    tailrec fun genSequence(
        n: Int,
        i: Int = 1,
        seq: ArrayList<Int> = arrayListOf()
    ): ArrayList<Int> {
        if (n == 0)
            return seq
        else
            seq.add(i)
        return genSequence(n - 1, i + 1, seq)
    }
    println(genSequence(5))
    /**
     * Задание 5: Создайте список имен и используйте функции let, run, also, apply и with
     * для выполнения различных операций над этим списком (например, добавьте имя, удалите имя, переверните список и т. д.).
     */

    val names = arrayListOf("Аня", "Саша", "Миша", "Даша", "Катя", "Вадим", "Артем")

    names.apply {
        add("Марина")
        remove("Миша")
        removeAt(4)
    }.also { println("Новый список имен $it") }

    names.run {
        println("Имена, начинающиеся на а: ${filter { it.get(0) == 'А' }}")
        println("Имена, заканчивающиеся на а: ${filter { it.get(it.length - 1) == 'а' }}")
        println("Список в обратном порядке: ${reversed()}")
    }

    var revertFirstName = names.first().let { firstName ->
        println("Первое имя в списке: $firstName")
        firstName.reversed()
    }.also { println("Перевернутое первое имя в списке: $it") }

    with(names) {
        removeAll { it.length < 4 }
        sort()
        println("Отсортированный список ${this}")
    }

}