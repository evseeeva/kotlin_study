/**
 * Класс petInfo - печатает информацию о домашнем питомце
 * @property petType - тип животного
 * @property petName - имя животного
 * @property petAge - возраст животного
 * @author Anastasia Evseeva
 */
class petInfo(val petType: String, val petName: String, val petAge: Int) {
    fun printInfo() {
        println("Поздравляем, вы счасливый обладатель $petType по имени $petName в течение $petAge лет!")
    }
}