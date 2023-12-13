package com.offline.first.designpatterns.behavioral.observer

interface IChannel<T> {

    fun subscribe(subscriber:  ISubscriber<T>)
    fun unSubscribe(subscriber:  ISubscriber<T>)

    fun notifySubscriber(any: T)
}