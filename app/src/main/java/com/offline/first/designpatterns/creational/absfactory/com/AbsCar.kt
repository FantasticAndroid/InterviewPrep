package com.offline.first.designpatterns.creational.absfactory.com

enum class CarType {
    HATCHBACK, SEDAN, SUV
}

enum class FactoryLocation {
    PUNE, MUMBAI, CHENNAI
}

abstract class AbsCar(val carType: CarType, val factoryLocation: FactoryLocation) {
    abstract fun price(): Int
}

class HatchbackCar(factoryLocation: FactoryLocation) : AbsCar(CarType.HATCHBACK, factoryLocation) {
    override fun price(): Int = 100
}

class SedanCar(factoryLocation: FactoryLocation) : AbsCar(CarType.SEDAN, factoryLocation) {
    override fun price(): Int = 1000
}

class SuvCar(factoryLocation: FactoryLocation) : AbsCar(CarType.SUV, factoryLocation) {
    override fun price(): Int = 10000
}