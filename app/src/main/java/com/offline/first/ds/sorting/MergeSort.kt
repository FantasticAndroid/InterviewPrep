package com.offline.first.ds.sorting

import android.util.Log

private const val TAG = "MergeSort"

@Deprecated("Need to improve not working yet")
object MergeSort {

    fun mergeWhileLoop(arr1: Array<Int>, arr2: Array<Int>): IntArray {
        Log.d(TAG, "mergeWhileLoop")
        val mergedArr = IntArray(size = arr1.size + arr2.size)
        var index1 = 0
        var index2 = 0
        var mergedIndex = 0
        while (index1 < arr1.size && index2 < arr2.size) {
            if (arr1[index1] < arr2[index2]) {
                mergedArr[mergedIndex] = arr1[index1]
                index1++
            } else {
                mergedArr[mergedIndex] = arr2[index2]
                index2++
            }
            mergedIndex++
        }
        while (index1 < arr1.size) {
            mergedArr[mergedIndex] = arr1[index1]
            index1++
            mergedIndex++
        }
        while (index2 < arr2.size) {
            mergedArr[mergedIndex] = arr2[index2]
            index2++
            mergedIndex++
        }
        return mergedArr
    }

    fun mergeRecursive(arr: Array<Int>, start: Int, end: Int) {
        Log.d(TAG, "mergeRecursive start: $start, end: $end")
        //val mergedArr = arrayOf(arr1) + arrayOf(arr2)

        if(start< end){
            val half :Int =  (start + end) / 2

            mergeRecursive(arr, start, half)
            mergeRecursive(arr, half+1, end)
            merge(arr, half, start, end)
        }
    }

    private fun merge(arr: Array<Int>, half:Int, start: Int, end: Int) {
        Log.d(TAG, "merge half: $half, start: $start, end: $end, arrSize: ${arr.size}")
        val mergedArray = IntArray(end-start+1)
        var indexL = start
        var indexR = half +1
        var mergedIndex = 0
        while(indexL <= half && indexR <=end){
            if(arr[indexL] < arr[indexR]){
                mergedArray[mergedIndex] = arr[indexL]
                indexL++
            }else{
                mergedArray[mergedIndex] = arr[indexR]
                indexR++
            }
            mergedIndex++
        }
        while(indexL <= half){
            mergedArray[mergedIndex] = arr[indexL]
            indexL++
            mergedIndex++
        }

        while(indexR <= end){
            mergedArray[mergedIndex] = arr[indexR]
            indexR++
            mergedIndex++
        }
        for (i in start..end) {
            arr[i] = mergedArray[i]
        }
        Log.d(TAG, "mergedArray: ${mergedArray.toList()}")
    }

    fun applyMergeSortDemo() {
        Log.d(TAG, "applyMergeSortDemo")
        val arr1 = arrayOf(-5, 0, 9, 12)
        val arr2 = arrayOf(2, 4, 7, 9, 11, 12, 13 )
        Log.d(TAG, "SortStart: arr1: ${arr1.toList()}, arr2: ${arr2.toList()}")
        val mergedArrW = mergeWhileLoop(arr1, arr2)
        Log.d(TAG, "SortEnd: mergedArrW: ${mergedArrW.toList()}")
        val arr = arr1 + arr2
        mergeRecursive(arr, 0 , arr.size-1)
        Log.d(TAG, "SortEnd: mergedArrR: ${arr.toList()}")
    }
}