package com.offline.first.ds.sorting

import android.util.Log
import java.util.Collections

private const val TAG= "SelectionSort"

/**
 * Start with 0 as Current item Index. Let i = 0
 * Find smallest item from items [i+1 to last]. (Forward Traversing)
 * Let say J is smallest item in [i+1 to last]. Swap J with ith Item.
 * and i = i + 1.
 * Again Traverse forward from (i+1) to last.
 */
object SelectionSort{

    fun forLoop(arr: Array<Int>){
        Log.d(TAG, "forLoop")
        for(pass in arr.indices){
            var indexOfMin:Int = pass
            for (index in pass + 1 until arr.size) {
                if(arr[index] < arr[indexOfMin]){
                    indexOfMin = index
                }
            }
            val temp = arr[pass]
            arr[pass] = arr[indexOfMin]
            arr[indexOfMin] = temp
        }
    }

    fun whileLoop(arr: Array<Int>){
        Log.d(TAG, "whileLoop")
        // In While loop
        var pass = 0
        while (pass < arr.size) {
            var indexOfMin = pass
            var index = pass + 1
            while (index < arr.size) {
                if (arr[index] < arr[indexOfMin]) {
                    indexOfMin = index
                }
                index++
            }
            val temp = arr[pass]
            arr[pass] = arr[indexOfMin]
            arr[indexOfMin] = temp
            pass++
        }
    }

    fun mutableList(arr: MutableList<Int>){
        Log.d(TAG, "mutableList")
        for(pass in arr.indices){
            var indexOfMin:Int = pass
            for (index in pass + 1 until arr.size) {
                if(arr[index] < arr[indexOfMin]){
                    indexOfMin = index
                }
            }
            Collections.swap(arr, pass, indexOfMin)
        }
    }

    fun applySelectionSortDemo(){
        Log.d(TAG, "applySelectionSortDemo")
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