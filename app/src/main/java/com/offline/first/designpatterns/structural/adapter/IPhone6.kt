package com.offline.first.designpatterns.structural.adapter

import android.util.Log
import com.offline.first.designpatterns.structural.adapter.com.charger.ICharger

class IPhone6 {

    /**
     * Every charge that is a type of ICharger will work
     * @param charger T
     */
    fun <T: ICharger> doCharge(charger: T) {
        // Log.d(TAG, "doCharge with: ${T::class.java}")
        // Compile type error: Cannot use 'T' as reified type parameter.
        // Use a class instead. Make T reified and doCharge inline
        charger.charge(100)
    }

    /**
     * Every charge that is a type of ICharger will work
     * @param charger T
     */
    inline fun <reified T: ICharger> doChargeThis(charger: T) {
        Log.d(TAG, "doChargeThis with: ${T::class.java}")
        charger.charge(100)
    }
}