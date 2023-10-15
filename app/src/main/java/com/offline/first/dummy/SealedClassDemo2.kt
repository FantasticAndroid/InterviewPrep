//package com.offline.first.dummy
//
//sealed interface Animal {
//    val name: String
//    fun makeSound()
//}
//
//class Dog(override val name: String): Animal {
//    override fun makeSound() {
//        println("$name says woof!")
//    }
//}
//
//class Cat(override val name: String): Animal {
//    override fun makeSound() {
//        println("$name says meow!")
//    }
//}
//
//class SealedClassDemo2 {
//    val myDog : Animal = Dog("Rufus")
//    val myCat : Animal = Cat("Whiskers")
//    myDog.makeSound() // outputs: "Rufus says woof!"
//    myCat.makeSound() // outputs: "Whiskers says meow!"
//}
//
