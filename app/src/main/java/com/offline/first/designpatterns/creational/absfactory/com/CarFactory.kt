package com.offline.first.designpatterns.creational.absfactory.com

object CarFactory {

    fun buildCar(carType: CarType, factoryLocation: FactoryLocation): AbsCar {
        return when (factoryLocation) {
            FactoryLocation.PUNE ->  PuneCarFactory(carType).buildCar()
            FactoryLocation.CHENNAI -> ChennaiCarFactory(carType).buildCar()
            FactoryLocation.MUMBAI -> MumbaiCarFactory(carType).buildCar()
        }
    }
}