package com.offline.first.ds.sorting

import android.util.Log
import java.util.Collections

private const val TAG= "BubbleSort"
object BubbleSort{

    fun whileLoop(arr: Array<Int>){

        Log.d(TAG, "whileLoop")
        var pass = arr.size
        while (pass >= 1) {
            for (index in 0..<(pass-1)) {
                if (arr[index] > arr[index + 1]) {
                    val temp = arr[index]
                    arr[index] = arr[index + 1]
                    arr[index + 1] = temp
                }
            }
            pass--
        }
    }

    fun forLoop(arr: Array<Int>){
        Log.d(TAG, "forLoop")
        for(pass in arr.size-1 downTo  0){
            for(index in 0 until pass){
                if (arr[index] > arr[index + 1]) {
                    val temp = arr[index]
                    arr[index] = arr[index + 1]
                    arr[index + 1] = temp
                }
            }
        }
    }

    fun mutableList(arr: MutableList<Int>){
        Log.d(TAG, "mutableList")
        var pass = arr.size
        while (pass >= 1) {
            for (index in 0..<(pass-1)) {
                if (arr[index] > arr[index + 1]) {
                    Collections.swap(arr, index, index+1)
                }
            }
            pass--
        }
    }

    fun applyBubbleSortDemo(){
        Log.d(TAG, "applyBubbleSortDemo")
        val arr = arrayOf(7, 11, 9, 2, 12, 4, 0, 12,-5, 13)
        Log.d(TAG, "SortStart: ${arr.toList()}")
        forLoop(arr)
        Log.d(TAG, "SortEnd: ${arr.toList()}")
        arr.shuffle()
        Log.d(TAG, "SortStart: ${arr.toList()}")
        whileLoop(arr)
        Log.d(TAG, "SortEnd: ${arr.toList()}")

        arr.shuffle()
        val arrM = arr.toMutableList()
        Log.d(TAG, "SortStart: $arrM")
        mutableList(arrM)
        Log.d(TAG, "SortEnd: $arrM")
    }
}