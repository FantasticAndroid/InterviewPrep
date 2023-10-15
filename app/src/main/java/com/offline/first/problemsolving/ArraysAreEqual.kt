package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "ArraysAreEqual"
object ArraysAreEqual {

    fun findArraysAreEqual(array1: Array<Int>, array2: Array<Int>) {
        val isEqual = if(array1.size != array2.size){
            false
        }else{
            val string1 = array1.joinToString()
            val string2 = array2.joinToString()
            Log.d(TAG, "findArraysAreEqual string1: $string1, string2: $string2")
            string1 == string2
        }
        Log.d(TAG, "findArraysAreEqual isEqual: $isEqual")
        findArraysAreEqual2(array1, array2)
    }

    fun findArraysAreEqual2(array1: Array<Int>, array2: Array<Int>) {
        val isEqual = if(array1.size != array2.size){
            false
        }else{
            var isEqual = true
            array1.forEachIndexed{ index, item1 ->
                if(item1 != array2[index]) {
                    isEqual = false
                    return@forEachIndexed
                }
            }
            isEqual
        }
        Log.d(TAG, "findArraysAreEqual2 isEqual: $isEqual")
    }
}