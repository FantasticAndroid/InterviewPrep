package com.offline.first.designpatterns.behavioral.observer

const val TAG = "ObserverPatternImpl"
object ObserverPatternImpl {

    fun applyObserverPattern(){

        val myChannel = MyChannel()

        val subscriber1 = Subscriber()
        myChannel.subscribe(subscriber1)

        val subscriber2 = Subscriber()
        myChannel.subscribe(subscriber2)

        val subscriber3 = Subscriber()
        myChannel.subscribe(subscriber3)

        myChannel.unSubscribe(subscriber2)

        myChannel.notifySubscriber("https://newvideo.mp3")
    }

}