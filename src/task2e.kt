fun main() {
    /**
     * Задание 1
     * Создайте список чисел от 1 до 10, затем используйте метод filter чтобы оставить только четные числа. После этого используйте метод map чтобы умножить каждое число на 2.
     */

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val doubleEvenNumbers = numbers.filter { it % 2 == 0 }.map { it * 2 }
    println(doubleEvenNumbers)

    /**
     * Задание 2
     * Создайте список строк [“один”, “два”, “три”, “четыре”, “пять”]. Используйте map чтобы получить длину каждого элемента списка.
     */

    val stringNumbers = listOf("один", "два", "три", "четыре", "пять")
    val length = stringNumbers.map { it.length }
    println(length)

    /**
     * Задание 3
     * Напишите функцию высшего порядка, которая принимает два параметра: целое число и функцию, принимающую целое число и возвращающую строку. Эта функция должна преобразовывать число в строку с помощью переданной функции и возвращать результат.
     */

    val mapNumberWithString: (Int) -> String = { n ->
        mapOf(
            0 to "ноль",
            1 to "один",
            2 to "два",
            3 to "три",
            4 to "четыре",
            5 to "пять",
            6 to "шесть",
            7 to "семь",
            8 to "восемь",
            9 to "девять"
        )
            .getOrDefault(n, "не определено")
    }

    fun numberToString(n: Int, operation: (Int) -> String): String {
        return operation(n)
    }
    println(numberToString(5, mapNumberWithString))
    println(numberToString(10, mapNumberWithString))

    /**
     * Задание 4
     * Создайте лямбда-функцию, которая принимает число и возвращает его квадрат. Используйте эту лямбда-функцию в другой функции, которая принимает число и возвращает строку, состоящую из числа и его квадрата (например, “5 и его квадрат равен 25”).
     */

    val square: (Int) -> Int = { n -> n * n }
    fun squareToString(n: Int, operation: (Int) -> Int): String {
        val result = operation(n)
        return "$n и его квадрат равен $result"
    }
    println(squareToString(12, square))

    /**
     * Задание 5
     * Создайте объект класса Person со свойствами name и age. Создайте список из нескольких таких объектов. Используйте filter и map чтобы получить список имен тех людей, которым больше 18 лет.
     */

    class Person(val name: String, val age: Int)

    val adultsPersons =  listOf(
        Person("Tom", 23),
        Person("Ann", 2),
        Person("Mary", 17),
        Person("Bill", 84)
    ).filter { it.age >= 18 }.map { it.name }
    println(adultsPersons)

    /**
     * Задание 6
     * Используя ленивые операции, создайте последовательность чисел от 1 до 1000, затем используйте filter чтобы оставить только числа, делящиеся на 5, затем map чтобы умножить каждое число на 2, и take чтобы взять первые 20 элементов этой последовательности.
     */

    val sequence = sequence {
        var num = 1
        while (num <= 1000) {
            yield(num++)
        }
    }
        .filter { it % 5 == 0 }
        .map { it * 5 }
    val result = sequence.take(20).toList()
    println(result)

    /**
     * Задание 7
     * Создайте класс Car с полями make, model и year. Создайте коллекцию из нескольких объектов этого класса и используйте groupBy чтобы сгруппировать машины по году выпуска.
     */

    class Car(val model: String, var color: String, var year: Int) {
        override fun toString(): String {
            return "{$model, $color, $year}"
        }
    }

    val cars = listOf(
        Car("Ford", "Blue", 2000),
        Car("Porsche", "black", 2020),
        Car("Mazda", "red", 2000),
        Car("Volga", "grey", 1980),
        Car("Lada", "green", 1980)
    )
    val groupedByYearCars = cars.groupBy { it.year }
    println(groupedByYearCars)

    /**
     * Задание 8
     * Создайте переменную lazyValue типа String, инициализируемую лениво. Проверьте, что инициализация действительно происходит только при первом обращении к переменной.
     */

    val lazyString: String by lazy {
        println("инициализация переменной")
        "ленивая строка"
    }
    println(lazyString)
    println(lazyString)

    /**
     * Задание 9
     * Создайте функцию высшего порядка calculate, которая принимает два целых числа и функцию операции. Продемонстрируйте использование calculate с разными операциями (сложение, вычитание, умножение).
     */

    val add: (Int, Int) -> Int = { a, b -> a + b }
    val subtract: (Int, Int) -> Int = { a, b -> a - b }
    val multiply: (Int, Int) -> Int = { a, b -> a * b }
    fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }
    println(calculate(2, 5, add))
    println(calculate(2, 5, subtract))
    println(calculate(2, 5, multiply))

    /**
     * Задание 10
     * Создайте коллекцию чисел и используйте fold или reduce чтобы посчитать их сумму, минимальное и максимальное значения.
     */

    val sum = numbers.reduce { sum, i -> sum + i }
    val min = numbers.reduce { min, i -> if (min < i) min else i }
    val max = numbers.reduce { max, i -> if (max > i) max else i }
    println(sum)
    println(min)
    println(max)

}
