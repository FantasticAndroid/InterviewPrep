package com.offline.first.programmings

import android.util.Log
import android.widget.ImageView

private const val TAG = "ExtensionFunDemo"

class ExtensionFunDemo {

    /*fun ImageView.extensionFun(color: Int) {
        this.setColorFilter(color)
    }*/

    // is actually in decompiled as JAVA
    fun extensionFun(iv: ImageView, color: Int) {
        iv.setColorFilter(color)
    }

    companion object Var{
        val variable1 = "Ram"
        const val variable2 = "Ram"
        var variable3 = "Ram"

        fun staticFun(){
            Log.d(TAG, " This is static FUN")
        }

        fun String.extensionFun(){

        }

    }
}

object Access{
    fun main(){
        ExtensionFunDemo.variable1
        ExtensionFunDemo.staticFun()
    }
}