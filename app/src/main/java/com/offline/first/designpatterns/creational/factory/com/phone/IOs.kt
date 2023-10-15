package com.offline.first.designpatterns.creational.factory.com.phone

import android.util.Log
import com.offline.first.designpatterns.creational.factory.TAG

class IOs : BaseOs {
    override fun spec() : String {
        Log.d(TAG, "This is Closed OS")
        return "This is Closed OS"
    }
}