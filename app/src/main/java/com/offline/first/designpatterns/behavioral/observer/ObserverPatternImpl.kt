package com.offline.first.designpatterns.behavioral.observer

const val TAG = "ObserverPatternImpl"
object ObserverPatternImpl {

    fun applyObserverPattern(){

        val myChannel = MyChannel<String>()

        val subscriber1 = Subscriber<String>()
        myChannel.subscribe(subscriber1)

        val subscriber2 = Subscriber<String>()
        myChannel.subscribe(subscriber2)

        val subscriber3 = Subscriber<String>()
        myChannel.subscribe(subscriber3)

        myChannel.unSubscribe(subscriber2)

        myChannel.notifySubscriber("https://newvideo.mp3")
    }

}