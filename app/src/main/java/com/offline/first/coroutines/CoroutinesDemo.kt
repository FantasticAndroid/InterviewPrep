package com.offline.first.coroutines

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val TAG = "CoroutinesDemo"
object CoroutinesDemo {

    fun applyRunBlocking(){
        runBlocking(Dispatchers.IO){
            Log.d(TAG, "runBlocking Start")
            launch {
                Log.d(TAG, "runBlocking launch Start")
                delay(2000)
                Log.d(TAG, "runBlocking launch End")
            }
            delay(3000)
            Log.d(TAG, "runBlocking End")
        }
    }

    fun applyG(){
        runBlocking(Dispatchers.IO){

            //Log.d()
        }
    }
}