package com.offline.first.programmings.kotlin

import com.offline.first.programmings.kotlin.ExtensionProp.salutation

object ExtensionProp {

    class Person(val name: String)

    // Extension Property
    val Person.salutation : String
        get() = "Hello $name!"
}

fun main() {
    val person = ExtensionProp.Person("John")
    println(person.salutation) // Output: Hello, John!
}
