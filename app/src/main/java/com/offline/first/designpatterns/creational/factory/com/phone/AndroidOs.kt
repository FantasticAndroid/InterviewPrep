package com.offline.first.designpatterns.creational.factory.com.phone

import android.util.Log
import com.offline.first.designpatterns.creational.factory.TAG

class AndroidOs : BaseOs {
    override fun spec() : String {
        Log.d(TAG, "This is Open OS")
        return "This is Open OS"
    }
}