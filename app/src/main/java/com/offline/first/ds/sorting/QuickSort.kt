package com.offline.first.ds.sorting

import android.util.Log

private const val TAG = "QuickSort"

/**
 * In initial START is 0, END = arr.size - 1
 *
 * Start from START index,say arr[ START ] item is Pivot. Let i = START
 * Start with i+1 and find index of element which is > Pivot. Let founded index is H
 * Similarly start from END and find index of element which is <= Pivot. Let founded index is S
 * If (H < S), swap values of those indexes.
 * Step -> Again, start with H and find index of element which is > Pivot. Let founded index is H
 * Again, start from S and find index of element which is <= Pivot. Let founded index is S
 * if(H<S), swap values of those indexes.
 * Continue these steps till H<S
 *
 * Now swap pivot with item in S index.
 * S is our partition index for now. Let say P = S
 *
 * Apply the same procedure for array where START = START, END = P-1        // Sort Left SubArray
 * And, Apply the same procedure for array where START = P+1, END = END     // Sort Right SubArray
 */
object QuickSort {

    /* This function takes end element as pivot, places the pivot element at its correct
       position in sorted array, and places all smaller (smaller than pivot) to left of
       pivot and all greater elements to right of pivot */
    private fun getPartitionIndex(arr: Array<Int>, start: Int, end: Int): Int {
        Log.d(TAG, "getPartitionIndex, start: $start, end: $end, arr: ${arr.toList()}")
        val pivot = arr[start]
        var indexOfHigher = start + 1 // (Let next to pivot element is smaller)
        var indexOfSmaller = end
        do {
            while (arr[indexOfHigher] <= pivot) {
                indexOfHigher++
            }
            //Log.d(TAG, "indexOfHigher: $indexOfHigher")
            while (arr[indexOfSmaller] > pivot) {
                indexOfSmaller--
            }
            //Log.d(TAG, "indexOfSmaller: $indexOfSmaller")
            if (indexOfHigher < indexOfSmaller) {
                val temp = arr[indexOfHigher]
                arr[indexOfHigher] = arr[indexOfSmaller]
                arr[indexOfSmaller] = temp
            }
        } while (indexOfHigher < indexOfSmaller)

        // Swap smaller element with start element
        val temp = arr[indexOfSmaller]
        arr[indexOfSmaller] = pivot
        arr[start] = temp
        return indexOfSmaller
    }

    private fun quickSort(arr: Array<Int>, start: Int, end: Int) {
        if (start < end) {
            val partitionIndex = getPartitionIndex(arr, start, end)
            Log.d(
                TAG,
                "quickSort, start: $start, end: $end, partitionIndex: $partitionIndex, arr: ${arr.toList()}"
            )
            quickSort(arr, start, partitionIndex - 1) // sort left sub array
            quickSort(arr, partitionIndex + 1, end) // sort right sub array
        } else {
            Log.d(TAG, "quickSort, start: $start, end: $end, arr: ${arr.toList()}")
        }
    }

    fun applyQuickSortDemo() {
        Log.d(TAG, "applyQuickSortDemo")
        //val arr = intArrayOf(15,5,6,0,4,8,1,9,2, 8, 5, 6, 3, 20, 25, 4, 17, 89, 100, 7, 13, 19, 500)
        val arr = arrayOf(7, 11, 9, 2, 12, 4, 0, 12, -5, 13)
        Log.d(TAG, "SortStart: ${arr.toList()}")
        quickSort(arr, 0, arr.size - 1)
        Log.d(TAG, "SortEnd: ${arr.toList()}")
    }
}