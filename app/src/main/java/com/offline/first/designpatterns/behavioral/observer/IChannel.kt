package com.offline.first.designpatterns.behavioral.observer

interface IChannel {

    fun subscribe(subscriber:  ISubscriber)
    fun unSubscribe(subscriber:  ISubscriber)

    fun notifySubscriber(newVideoUrlToWatch: String)
}