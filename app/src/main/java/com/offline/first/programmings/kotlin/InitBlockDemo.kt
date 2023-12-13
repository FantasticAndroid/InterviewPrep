package com.offline.first.programmings.kotlin

/**
 * At First  Primary Constructor will call
 * Then Init block calls Sequentially from top to bottom
 * Then Secondary Constructor will call
 * @property greeting String
 * @property name String
 * @property age Int
 */
class Person {
    var greeting: String
    var name:String = ""
    var age :Int = -1
    init {
        greeting = "Hello1, $name!"
        println("Person initialized1 $greeting")
    }

    constructor(name: String){
        this.name= name
        println("Person name $name")
    }

    constructor(age:Int){
        this.age = age
    }

    init {
        greeting = "Hello2, $name!"
        println("Person initialized $greeting")
    }
}

fun main() {
    val person = Person("John") // Output: Person initialized
    println(person.greeting) // Output: Hello, John!
}