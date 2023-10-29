package com.offline.first.designpatterns.structural.adapter.com.charger

import android.util.Log
import com.offline.first.designpatterns.creational.objectpool.TAG

class IPhone4Charger {
    /**
     * Current to charge iPhone 4
     * @param current Int
     */
    fun charge(current: Int) {
        Log.d(TAG, "charge IPhone4 with current: Current: $current")
    }
}