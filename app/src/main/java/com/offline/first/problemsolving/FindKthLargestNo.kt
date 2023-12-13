package com.offline.first.problemsolving

import android.util.Log

object FindKthLargestNo {

    fun demoQuickSort() {

        //val arr = intArrayOf(15,5,6,0,4,8,1,9,2, 8, 5, 6, 3, 20, 25, 4, 17, 89, 100, 7, 13, 19, 500)\
        val arr = intArrayOf(3, 2, 1, 5, 6, 4, 10, 2, 4)
        val kthLargest = 1
        val kthIndex = arr.size - kthLargest
        val start = 0
        val end = arr.size - 1
        Log.d("FindKthLargestNo", "SortStart: ${arr.toList()}")
        quickSort(arr, start, end, kthIndex)
    }

    private fun quickSort(arr: IntArray, start: Int, end: Int, kthIndex: Int) {
        if (start < end) {
            val partitionIndex = getPartitionIndex(arr, start, end)
            Log.d(
                "FindKthLargestNo",
                "start: $start, startVal: ${arr[start]}, end: $end, endVal: ${arr[end]}, partitionIndex: $partitionIndex, value: ${arr[partitionIndex]}"
            )

            if (partitionIndex == kthIndex) {
                Log.d("FindKthLargestNo", "kthLargest: $start, Value: ${arr[kthIndex]}")
                return
            } else if (partitionIndex > kthIndex) {
                quickSort(arr, start, partitionIndex - 1, kthIndex)
            } else {
                quickSort(arr, partitionIndex + 1, end, kthIndex)
            }
        } else {
            Log.d("FindKthLargestNo", "else arr: ${arr.toList()}")
        }
    }

    private fun getPartitionIndex(arr: IntArray, start: Int, end: Int): Int {
        val pivotValue = arr[start]
        var indexOfMax = start + 1
        var indexOfMin = end

        do {
            while (arr[indexOfMax] <= pivotValue) {
                indexOfMax++
            }
            while (arr[indexOfMin] > pivotValue) {
                indexOfMin--
            }
            if (indexOfMax < indexOfMin) {
                val temp = arr[indexOfMax]
                arr[indexOfMax] = arr[indexOfMin]
                arr[indexOfMin] = temp
            }
        } while (indexOfMax < indexOfMin)

        val temp = arr[indexOfMin]
        arr[indexOfMin] = pivotValue
        arr[start] = temp
        return indexOfMin
    }
}