package com.offline.first.designpatterns.creational.factory.com.phone

enum class OsType {
    ANDROID, IOS, WINDOWS
}

interface BaseOs {
    // Factory Method
    fun spec(): String
}