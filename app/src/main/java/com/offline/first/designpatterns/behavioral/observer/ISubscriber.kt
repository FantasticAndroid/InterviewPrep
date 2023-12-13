package com.offline.first.designpatterns.behavioral.observer

interface ISubscriber<T> {

     fun onObserved(any: T)
}