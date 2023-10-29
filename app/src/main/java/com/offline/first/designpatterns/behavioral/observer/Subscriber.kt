package com.offline.first.designpatterns.behavioral.observer

import android.util.Log

class Subscriber : ISubscriber {
    override fun onObserved(newVideoUrlToWatch: String) {
        Log.d(TAG,"Subscriber onObserved newVideoUrlToWatch: $newVideoUrlToWatch")
        // Subscriber will now watch video
    }
}