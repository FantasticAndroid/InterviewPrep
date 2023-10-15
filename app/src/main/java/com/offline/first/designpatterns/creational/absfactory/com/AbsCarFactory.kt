package com.offline.first.designpatterns.creational.absfactory.com

/**
 * Abstract factory class (Abstract factory pattern)
 * @property carType CarType
 * @property factoryLocation FactoryLocation
 * @constructor
 */
abstract class AbsCarFactory(
    private val carType: CarType,
    private val factoryLocation: FactoryLocation
) {
    //abstract fun buildCar(): AbsCar

    fun buildCar(): AbsCar {
        return when (carType) {
            CarType.HATCHBACK -> HatchbackCar(factoryLocation)
            CarType.SEDAN -> SedanCar(factoryLocation)
            CarType.SUV -> SuvCar(factoryLocation)
        }
    }
}

class PuneCarFactory(carType: CarType) : AbsCarFactory(carType, FactoryLocation.PUNE)

class MumbaiCarFactory(carType: CarType) : AbsCarFactory(carType, FactoryLocation.MUMBAI)

class ChennaiCarFactory(carType: CarType) : AbsCarFactory(carType, FactoryLocation.CHENNAI)