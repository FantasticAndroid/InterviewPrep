package com.offline.first.designpatterns.behavioral.observer

interface ISubscriber {

    fun onObserved(newVideoUrlToWatch: String)
}