package com.offline.first.designpatterns.behavioral.observer

import android.util.Log

class Subscriber<T> : ISubscriber<T> {

    override fun onObserved(any: T) {
        Log.d(TAG,"Subscriber onObserved newVideoUrlToWatch: $any")
        // Subscriber will now watch video
    }
}