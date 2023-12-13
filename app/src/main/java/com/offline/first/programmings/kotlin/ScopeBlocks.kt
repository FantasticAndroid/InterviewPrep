package com.offline.first.programmings.kotlin

object ScopeBlocks{
    data class Person(var name: String, var age: Int)
}
fun main() {
    val person = ScopeBlocks.Person("John", 25)

    val modifiedPersonAlso : ScopeBlocks.Person = person.also {
        it.age = 35
    }
    println("Also: $modifiedPersonAlso") // Output: Person(name=John, age=35)
    val modifiedPersonApply : ScopeBlocks.Person = person.apply {
        age = 30
    }
    println("apply: $modifiedPersonApply") // Output: Person(name=John, age=30)


    val modifiedPersonWith : ScopeBlocks.Person = with(person){
        age = 40
        person
    }
    println("apply: $modifiedPersonApply") // Output: Person(name=John, age=30)

    println(modifiedPersonAlso) // Output: Person(name=John, age=35)
    println(modifiedPersonApply) // Output: Person(name=John, age=30)
    println(modifiedPersonWith) // Output: Person(name=John, age=40)
}