package com.offline.first.designpatterns.behavioral.observer

class MyChannel<T> : IChannel<T>{

    private val subscriberList = HashSet<ISubscriber<T>>()

    override fun subscribe(subscriber: ISubscriber<T>) {
        subscriberList.add(subscriber)
    }

    override fun unSubscribe(subscriber: ISubscriber<T>) {
        subscriberList.remove(subscriber)
    }

    override fun notifySubscriber(any: T) {
        subscriberList.forEach {
            it.onObserved(any)
        }
    }
}