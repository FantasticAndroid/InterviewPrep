package com.offline.first.designpatterns.creational.absfactory

import android.util.Log
import com.offline.first.designpatterns.creational.absfactory.com.AbsCar
import com.offline.first.designpatterns.creational.absfactory.com.AbsCarFactory
import com.offline.first.designpatterns.creational.absfactory.com.CarFactory
import com.offline.first.designpatterns.creational.absfactory.com.CarType
import com.offline.first.designpatterns.creational.absfactory.com.FactoryLocation
import com.offline.first.designpatterns.creational.absfactory.com.PuneCarFactory

const val TAG = "AbsFactoryImpl"

/**
 * Define an interface or abstract class for creating families of related (or dependent) objects
 * but without specifying their concrete sub-classes.
 *
 * Abstract Factory pattern is almost similar to Factory Pattern
 * and is considered as another layer of abstraction over factory pattern.
 *
 * An Abstract Factory Pattern is also known as Kit.
 *
 * Abstract Factory Pattern isolates the client code from concrete (implementation) classes.
 *
 * Abstract Factory Pattern eases the exchanging of object families.
 *
 * Abstract Factory Pattern promotes consistency among objects.
 */
object AbsFactoryImpl {
    fun implementFactoryDesignPattern() {

        val car : AbsCar = CarFactory.buildCar(CarType.SUV, FactoryLocation.PUNE)
        Log.d(
            TAG,
            "carType: ${car.carType}, factoryLocation: ${car.factoryLocation}, price: ${car.price()}"
        )

        // OR

        val carFactory : AbsCarFactory = PuneCarFactory(CarType.SUV)
        val puneCar: AbsCar = carFactory.buildCar()
        Log.d(
            TAG,
            "puneCarType: ${puneCar.carType}, factoryLocation: ${puneCar.factoryLocation}, price: ${puneCar.price()}"
        )
    }
}