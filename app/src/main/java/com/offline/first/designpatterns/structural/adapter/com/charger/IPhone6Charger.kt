package com.offline.first.designpatterns.structural.adapter.com.charger

import android.util.Log
import com.offline.first.designpatterns.creational.objectpool.TAG

/**
 * Using this interface, the existing object can safely call the adapter’s methods.
 */
class IPhone6Charger : ICharger {

    override fun charge() {
        Log.d(TAG,"charge IPhone6")
    }
}