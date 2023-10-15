package com.offline.first.dummy

sealed class SealedClassDemo() {
    class Apple() : SealedClassDemo()
    class Orange() : SealedClassDemo()
    open class UnknownFruit(): SealedClassDemo()
}
class Grape : SealedClassDemo()
class Tomato : SealedClassDemo.UnknownFruit() // Acceptable

/*************/
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val error: Exception) : Result<Nothing>()
}


