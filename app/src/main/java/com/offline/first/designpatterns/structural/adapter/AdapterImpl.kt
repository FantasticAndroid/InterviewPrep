package com.offline.first.designpatterns.structural.adapter

import com.offline.first.designpatterns.structural.adapter.com.charger.ICharger
import com.offline.first.designpatterns.structural.adapter.com.charger.IPhone4Charger
import com.offline.first.designpatterns.structural.adapter.com.charger.IPhone6Charger

const val TAG = "AdapterImpl"

object AdapterImpl {

    fun applyAdapterImpl() {

        val iphone6 = IPhone6()
        iphone6.doCharge(IPhone6Charger()) // It will work since we have IPhone6Charger which is compatible
        // But if we want to charge iphone 6 with IPhone4Charger, it will not work
        //iphone6.doCharge(IPhone4Charger()) // Not Compiled, because IPhone4Charger is not compatible or accessible

        val phoneAdapter: ICharger = PhoneAdapter()
        iphone6.doChargeThis(phoneAdapter)
    }
}

class PhoneAdapter : ICharger {

    private val iPhone4Charger = IPhone4Charger()

    /**
     * Upon receiving a call, the adapter passes the request to the second object,
     * but in a format and order that the second object expects.
     */
    override fun charge(current: Long) {
        iPhone4Charger.charge(current.toInt())
    }
}