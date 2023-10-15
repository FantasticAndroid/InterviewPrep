package com.offline.first.ds.sorting

import android.util.Log
import java.util.Collections

private const val TAG= "CountSort"
object CountSort{

    fun forLoop(arr: Array<Int>){
        Log.d(TAG, "whileLoop")
        // In While loop
        // At first read the max element from arr
        var max = arr[0]
        for(data in arr){
            if(data > max){
                max = data
            }
        }
        // Create array of max+1 size with 0 as default value in it
        val counterArray = Array<Int>(max+1) {
            0
        }
        // fil counter array as arr data map with count array indexes
        for(data in arr){
            counterArray[data]++
        }

        var sortedIndex = 0
        for(index in counterArray.indices){
            // Read no of counts from counter array
            for(count in counterArray[index] downUntil 0){
                // Set the actual no which is index in arr.
                arr[sortedIndex] = index
                sortedIndex++
            }
        }
        Log.d(TAG, "SortEnd: ${arr.toList()}")
    }

    infix fun Int.downUntil(to: Int): IntProgression {
        if (to >= Int.MAX_VALUE) return IntRange.EMPTY
        return this downTo (to + 1).toInt()
    }

    fun applyCountSortDemo(){
        Log.d(TAG, "applyCountSortDemo")
        // Counter sort does not work with negative numbers
        val arr = arrayOf(7, 11, 9, 2, 12, 4, 0, 12, 5, 13)
        Log.d(TAG, "SortStart: ${arr.toList()}")
        forLoop(arr)
        Log.d(TAG, "SortEnd: ${arr.toList()}")
    }
}