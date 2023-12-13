package com.offline.first.programmings

import android.util.Log

private const val TAG = "HigherOrderFunDemo"
object HigherOrderFunDemo {

    fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
        return operation(x,y)
    }

    fun main(){
        val result : Int = calculate(5, 3) { a, b -> a + b }
        Log.d(TAG, "calculate: result: $result")
    }

    /*fun operation(a: Int, b: Int): Int{
        return a + b
    }*/
}