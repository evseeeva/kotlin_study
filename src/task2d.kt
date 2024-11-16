import kotlin.math.PI

fun main() {

    /**
     * Задание 1
     * Создайте класс Car с полями model, color, year и методом drive(). Создайте несколько объектов этого класса и вызовите их метод drive().
     */

    val car1 = Car("Porsche", "black", 2020)
    val car2 = Car("Mazda", "red", 2000)
    val car3 = Car("Volga", "grey", 1980)
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

    val person = PersonPrivate()
    person.setName("Tom")
    person.setAge(20)
    println("Person: name - ${person.getName()}, age - ${person.getAge()}")

    /**
     * Задание 5
     * В классе Person добавьте custom геттеры и сеттеры для свойств name и age. Убедитесь, что вы можете управлять доступом к этим свойствам извне класса. Например, вы можете реализовать проверку возраста в сеттере, чтобы убедиться, что возраст неотрицательный.
     */

    val person2 = Person()
    person2.name = "Jerry"
    person2.age = 3
    println("Person: name - ${person2.name}, age - ${person2.age}")

    /**
     * Задание 6
     * Создайте класс Animal с методом makeSound(), затем создайте классы Dog и Cat, наследующие от Animal, и переопределите метод makeSound(). Создайте объекты Dog и Cat и вызовите их методы makeSound().
     */

    val cat: Animal = Cat()
    val dog: Animal = Dog()
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
    val circle: Circle = Circle(5.0)
    println("Circle area = ${circle.area()}")
    val rectangle: Rectangle = Rectangle(2.0, 3.0)
    println("Rectangle area = ${rectangle.area()}")

    /**
     * Задание 9
     * Создайте интерфейс Flyable с методом fly() и интерфейс Navigable  с методом navigate(), затем создайте классы Bird и Airplane, реализующие эти интерфейсы. Создайте объекты Bird и Airplane и вызовите их методы fly() и navigate().
     */

    val bird: Bird = Bird()
    bird.fly()
    bird.navigate()
    val airplane: Airplane = Airplane()
    airplane.fly()
    airplane.navigate()

    /**
     * Задание 10
     * Создайте data class User с двумя свойствами и методом printInfo(), который выводит информацию о пользователе. Создайте объект User и вызовите его метод printInfo().
     */

    val user: User = User(831829, "Sue")
    user.printInfo()

    /**
     * Задание 11
     * Создайте sealed class MathOperation и несколько объектов, представляющих различные математические операции (например, Add, Subtract, Multiply, Divide). Создайте функцию, которая принимает MathOperation и два числа, и выполняет соответствующую операцию.
     */

    println(performMathOperation(Add, 6.5, 7.0))

    /**
     * Задание 12
     * Создайте два класса: Mammal и CanFly. В классе Mammal определите метод breastfeed(), а в классе CanFly - метод fly(). Затем создайте класс Bat, который сочетает в себе оба этих поведения (с помощью композиции).
     */

    val bat = Bat(mammal = Mammal(), canFly = CanFly())
    bat.performFly()
    bat.performBreastFeed()

    /**
     * Задание 13
     * Создайте классы Engine и Tires. Затем создайте класс Car, который получает Engine и Tires через конструктор (Dependency Injection).
     */

    val carDI = CarDI(Tires(), Engine())
    carDI.drive()

    /**
     * Задание 14
     * Создайте обобщенный интерфейс Repository<T>, который содержит методы для сохранения (save(item: T)), удаления (delete(item: T)) и получения всех элементов (getAll(): List<T>). Реализуйте этот интерфейс в классе UserRepository для работы с объектами класса User.
     */

    val userRepository = UserRepository<User>()
    userRepository.save(user)
    userRepository.save(User(1832923, "Andy"))
    println(userRepository.getAll())
    userRepository.delete(user)
    println(userRepository.getAll())
}


class Car(val model: String, var color: String, var year: Int) {
    fun drive() {
        println("Car  $model $color $year is driving")
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
    private var name = "Unknown"
    private var age = 0

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String {
        return this.name
    }

    fun setAge(age: Int) {
        this.age = age
    }

    fun getAge(): Int {
        return this.age
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

data class User(val id: Int, val nickname: String) {
    fun printInfo() {
        println(toString())
    }
}

sealed class MathOperation

object Add : MathOperation()
object Subtract : MathOperation()
object Multiply : MathOperation()
object Divide : MathOperation()

fun performMathOperation(mathOperation: MathOperation, a: Double, b: Double): Double {
    return when (mathOperation) {
        Add -> a + b
        Subtract -> a - b
        Multiply -> a * b
        Divide -> a / b
    }
}


class Bat() {
    private var mammal: Mammal? = null
    private var canFly: CanFly? = null

    constructor(mammal: Mammal, canFly: CanFly) : this() {
        this.mammal = mammal
        this.canFly = canFly
    }

    fun performFly() {
        canFly?.fly()
    }

    fun performBreastFeed() {
        mammal?.breastfeed()
    }
}

open class Mammal {
    fun breastfeed() {
        println("Feeds children with breast milk")
    }
}

open class CanFly {
    fun fly() {
        println("Can fly")
    }
}

class CarDI(private val tires: Tires, private val engine: Engine) {
    fun drive() {
        engine.start()
        tires.move()
    }
}

open class Tires {
    fun move() {
        println("The wheels аre spinning")
    }
}

open class Engine {
    fun start() {
        println("The engine starts")
    }
}

interface Repository<T> {
    fun save(item: T)
    fun delete(item: T)
    fun getAll(): List<T>
}

class UserRepository<User> : Repository<User> {
    private var userList = mutableListOf<User>()
    override fun save(item: User) {
        userList.add(item)
    }

    override fun delete(item: User) {
        userList.remove(item)
    }

    override fun getAll(): List<User> {
        return userList
    }
}



