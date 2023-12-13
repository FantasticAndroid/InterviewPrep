package com.offline.first.programmings.kotlin

object CoAndContraVariance {
    // CoVariance
    // ContraVariance

    open class Animal
    class Dog : Animal()

    /**
     * CoVariance
     */
    interface Container<out T> {
        fun getItem(): T // Only OUT
        // fun process(item : T) // Can not IN
    }

    /**
     * ContraVariance
     */
    interface Processor<in T> {
        // fun getItem(): T // Can out OUT
        fun process(item : T) // Only IN
    }

    fun main() {
        val dogContainer: Container<Dog> = object : Container<Dog> {
            override fun getItem(): Dog {
                return Dog()
            }
        }
        val animalContainer: Container<Animal> = dogContainer // Covariance

        // But

        /*val animalContainer: Container<Animal> = object : Container<Animal> {
            override fun getItem(): Animal {
                return Animal()
            }
        }
        val dogContainer: Container<Dog> = animalContainer // Covariance Not Work here*/


        val animalProcessor: Processor<Animal> = object : Processor<Animal> {
            override fun process(item: Animal) {
                println("Processing animal: $item")
            }
        }
        val dogProcessor: Processor<Dog> = animalProcessor // Contravariance

        // But

        /*val dogProcessor: Processor<Dog> = object : Processor<Dog> {
            override fun process(item: Dog) {
                println("Processing Dog: $item")
            }
        }
        val animalProcessor: Processor<Animal> = dogProcessor // Contravariance Not Work here*/
    }
}