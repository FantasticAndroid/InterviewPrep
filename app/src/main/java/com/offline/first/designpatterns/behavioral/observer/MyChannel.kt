package com.offline.first.designpatterns.behavioral.observer

class MyChannel : IChannel{

    private val subscriberList = HashSet<ISubscriber>()

    override fun subscribe(subscriber: ISubscriber) {
        subscriberList.add(subscriber)
    }

    override fun unSubscribe(subscriber: ISubscriber) {
        subscriberList.remove(subscriber)
    }

    override fun notifySubscriber(newVideoUrlToWatch: String) {
        subscriberList.forEach {
            it.onObserved(newVideoUrlToWatch)
        }
    }
}