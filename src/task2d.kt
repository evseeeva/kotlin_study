import kotlin.math.PI

fun main() {

    /**
     * Задание 1
     * Создайте класс Car с полями model, color, year и методом drive(). Создайте несколько объектов этого класса и вызовите их метод drive().
     */

    var car1: Car = Car("Porshe", "black", 2020)
    var car2: Car = Car("Mazda", "red", 2000)
    var car3: Car = Car("Volga", "grey", 1980)
    car1.drive()
    car2.drive()
    car3.drive()

    /**
     * Задание 2
     * Создайте enum class DayOfWeek, содержащий все дни недели. Выведите все дни недели, используя свойства values и name этого enum.
     */

    for (day in DayOfWeek.values()) {
        println("name: ${day.name}, ordinal: ${day.ordinal}")
    }

    /**
     * Задание 3
     * Создайте объект Singleton с методом printMessage(), который выводит любое сообщение. Вызовите этот метод.
     */
    Singleton.printMessage()

    /**
     * Задание 4
     * Создайте класс Person с приватными свойствами name, age и публичными методами getName() и getAge(). Проверьте, что прямой доступ к этим свойствам невозможен извне класса.
     */

    var person: PersonPrivate = PersonPrivate()
    person.setName("Tom")
    person.setAge(20)
    println("Person: name - ${person.getName()}, age - ${person.getAge()}")

    /**
     * Задание 5
     * В классе Person добавьте custom геттеры и сеттеры для свойств name и age. Убедитесь, что вы можете управлять доступом к этим свойствам извне класса. Например, вы можете реализовать проверку возраста в сеттере, чтобы убедиться, что возраст неотрицательный.
     */

    var person2: Person = Person()
    person2.name = "Jerry"
    person2.age = 3
    println("Person: name - ${person2.name}, age - ${person2.age}")

    /**
     * Задание 6
     * Создайте класс Animal с методом makeSound(), затем создайте классы Dog и Cat, наследующие от Animal, и переопределите метод makeSound(). Создайте объекты Dog и Cat и вызовите их методы makeSound().
     */

    var cat: Animal = Cat()
    var dog: Animal = Dog()
    cat.makeSound()
    dog.makeSound()

    /**
     * Задание 7
     * Создайте класс MathUtils и перегрузите функцию add(), чтобы она могла принимать два или три целых числа.
     */

    MathUtils.add(2, 3)
    MathUtils.add(2, 3, 4)

    /**
     * Задание 8
     * Создайте абстрактный класс Shape с абстрактным методом area(), затем создайте классы Circle и Rectangle, реализующие этот метод. Создайте объекты Circle и Rectangle и выведите их площадь.
     */
    var circle: Circle = Circle(5.0)
    println("Circle area = ${circle.area()}")
    var rectangle: Rectangle = Rectangle(2.0, 3.0)
    println("Rectangle area = ${rectangle.area()}")

    /**
     * Задание 9
     * Создайте интерфейс Flyable с методом fly() и интерфейс Navigable  с методом navigate(), затем создайте классы Bird и Airplane, реализующие эти интерфейсы. Создайте объекты Bird и Airplane и вызовите их методы fly() и navigate().
     */

    var bird: Bird = Bird()
    bird.fly()
    bird.navigate()
    var airplane: Airplane = Airplane()
    airplane.fly()
    airplane.navigate()

}


class Car(_model: String, _color: String, _year: Int) {
    val model: String = _model
    var color: String = _color
    var year: Int = _year
    fun drive() {
        println("Car  ${model} ${color} ${year} is driving")
    }
}

enum class DayOfWeek() {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

object Singleton {
    val message: String = "Message from singleton object"
    fun printMessage() {
        println(message)
    }
}

class PersonPrivate {
    private var name: String = "Unknown"
    private var age: Int = 0

    fun setName(_name: String) {
        name = _name
    }

    fun getName(): String {
        return name
    }

    fun setAge(_age: Int) {
        age = _age
    }

    fun getAge(): Int {
        return age
    }
}

class Person {
    var name: String = "Unknown"
        set(value) {
            println("Setting name to $value")
            field = value
        }
        get() {
            println("Getting name")
            return field
        }
    var age: Int = 0
        set(value) {

            if (value > 0) {
                println("Setting age to $value")
                field = value
            } else
                println("Age must be a positive number")
        }
        get() {
            println("Getting age")
            return field
        }
}

open class Animal {
    open fun makeSound() {
        println("The animal makes a sound")
    }
}

class Dog : Animal() {
    override fun makeSound() {
        println("The dog is barking")
    }
}

class Cat : Animal() {
    override fun makeSound() {
        println("The cat is meowing")
    }
}

class MathUtils {
    companion object {
        fun add(a: Int, b: Int): Int {
            return a + b
        }

        fun add(a: Int, b: Int, c: Int): Int {
            return a + b + c
        }
    }
}

abstract class Shape() {
    abstract fun area(): Double
}

class Rectangle(val _length: Double, val _width: Double) : Shape() {
    val length: Double = _length
    var width: Double = _width
    override fun area(): Double {
        return Math.round(length * width * 100) / 100.toDouble()
    }
}

class Circle(val _r: Double) : Shape() {
    val r: Double = _r
    override fun area(): Double {
        return Math.round(PI * r * 100) / 100.toDouble()
    }
}

interface Flyable {
    fun fly()
}

interface Navigable {
    fun navigate()
}

class Bird : Flyable, Navigable {
    override fun fly() {
        println("The bird flies using their wings")
    }

    override fun navigate() {
        println("The bird navigates by the sun, stars, moon and ground landmarks")
    }
}

class Airplane : Flyable, Navigable {
    override fun fly() {
        println("The airplane flies using turbines and an engine")
    }

    override fun navigate() {
        println("The airplane navigates using the GPS system")
    }
}
