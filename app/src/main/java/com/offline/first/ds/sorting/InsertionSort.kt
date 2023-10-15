package com.offline.first.ds.sorting

import android.util.Log
import java.util.Collections

private const val TAG = "InsertionSort"

/**
 * Insert smallest item to the left of the array and so on.
 * Start with Second index to Last Index, Compare Current Index with Current -1
 * If [Current < Current -1] then swap Current with Current-1 until 0th index. (Backward traverse)
 */
object InsertionSort {

    fun forLoop(arr: Array<Int>) {
        Log.d(TAG, "forLoop")
        for (pass in 1 until arr.size) {
            for (index in pass downTo 1) {
                if (arr[index] < arr[index - 1]) {
                    val temp = arr[index]
                    arr[index] = arr[index - 1]
                    arr[index - 1] = temp
                }
            }
        }
    }

    fun whileLoop(arr: Array<Int>) {
        Log.d(TAG, "whileLoop")
        // In While loop
        var pass = 1
        while (pass < arr.size) {
            var index = pass
            while (index >= 1) {
                if (arr[index] < arr[index - 1]) {
                    val temp = arr[index]
                    arr[index] = arr[index - 1]
                    arr[index - 1] = temp
                }
                index--
            }
            pass++
        }
    }

    fun mutableList(arr: MutableList<Int>) {
        Log.d(TAG, "mutableList")
        for (pass in 1 until arr.size) {
            for (index in pass downTo 1) {
                if (arr[index] < arr[index - 1]) {
                    Collections.swap(arr, index, index - 1)
                }
            }
        }
    }

    fun applyInsertionSortDemo() {
        Log.d(TAG, "applyInsertionSortDemo")
        val arr = arrayOf(11, 7, 9, 2, 12, 4, 0, 12, -5, 13)
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