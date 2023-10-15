package com.offline.first.ds.search

import android.util.Log
import com.offline.first.ds.sorting.SelectionSort

private const val TAG = "BinarySearch"
/*Case	Time Complexity
Best Case	O(1)
Average Case	O(logn)
Worst Case	O(logn)*/

object BinarySearch {

    /**
     *
     * @param arr Array<Int>
     * @param start Int
     * @param end Int
     * @param item Int
     * @return Int
     */
    private fun binarySearch(arr: Array<Int>, start: Int, end: Int, item: Int): Int {

        if (end < start)
            return -1

        val mid = (start + end) / 2

        Log.d(TAG, "binarySearch start: $start, end: $end, mid: $mid, item: $item, arr: ${arr.toList()}")
        return if (item == arr[mid])
            mid
        else if (item < arr[mid]) {
            binarySearch(arr, start, mid - 1, item)
        } else {
            binarySearch(arr, mid + 1, end, item)
        }
    }

    private fun search(arr: Array<Int>, item: Int) : Int{
        Log.d(TAG, "search item: $item, arr: ${arr.toList()}")
        return binarySearch(arr, 0, arr.size- 1, item)
    }

    fun applyBinarySearch() {
        val arr = arrayOf(30, 14, 25, -5, 40, 11, 0, 57, 10, 5)
        SelectionSort.forLoop(arr)
        arr.forEach {
            val index = search(arr, it)
            Log.d(TAG, "applyBinarySearch, item:$it, index: $index")
        }

    }
}