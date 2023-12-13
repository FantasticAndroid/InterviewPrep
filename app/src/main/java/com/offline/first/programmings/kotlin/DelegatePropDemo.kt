package com.offline.first.programmings.kotlin

import android.util.Log

private const val TAG = "DelegatePropDemo"
class DelegatePropDemo {

    val valueString : String by lazy {
        println("Init valueString")
        "RAM"
    }
}

fun main(){

    val propDemo = DelegatePropDemo()
    Log.d(TAG, "valueString1: ${propDemo.valueString}" )
    Log.d(TAG, "valueString2: ${propDemo.valueString}" )
}