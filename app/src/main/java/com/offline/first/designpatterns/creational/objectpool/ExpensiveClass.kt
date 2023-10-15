package com.offline.first.designpatterns.creational.objectpool

import android.util.Log

class ExpensiveClass(private val pollIndex: Int) {

    fun doExpensiveOperation(){
        Log.d(TAG, "doExpensiveOperation pollIndex: $pollIndex")
    }
}