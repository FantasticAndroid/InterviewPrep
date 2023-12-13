package com.offline.first.dummy

import android.util.Log

object Demo {

    fun demoQuickSort() {

        //val arr = intArrayOf(15,5,6,0,4,8,1,9,2, 8, 5, 6, 3, 20, 25, 4, 17, 89, 100, 7, 13, 19, 500)\
        val arr = intArrayOf(3, 2, 1, 5, 6, 4)
        val start = 0
        val end = arr.size - 1
        Log.d("demoQuickSort", "SortStart: ${arr.toList()}")
        quickSort(arr, start, end)
    }

    private fun quickSort(arr: IntArray, start: Int, end: Int) {
        if (start < end) {
            val partitionIndex = getPartitionIndex(arr, start, end)
            Log.d(
                "demoQuickSort",
                "start: $start, startVal: ${arr[start]}, end: $end, endVal: ${arr[end]}, partitionIndex: $partitionIndex, value: ${arr[partitionIndex]}"
            )

            quickSort(arr, start, partitionIndex - 1)
            quickSort(arr, partitionIndex + 1, end)
        } else {
            Log.d("demoQuickSort", "else arr: ${arr.toList()}")
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

    fun demoSelectionSort() {
        val arr = intArrayOf(15, 5, 6, 0, 4, 8, 1, 9, 2)
        for (pass in arr.indices) {
            var indexOfMin = pass
            for (index in pass + 1 until arr.size) {
                if (arr[indexOfMin] > arr[index]) {
                    indexOfMin = index
                }
            }
            val temp = arr[pass]
            arr[pass] = arr[indexOfMin]
            arr[indexOfMin] = temp
        }

        Log.d("demoSelectionSort", "arr: ${arr.toList()}")
    }

    fun demoInsertionSort() {
        val arr = intArrayOf(15, 5, 6, 0, 4, 8, 1, 9, 2)

        for (pass in 1 until arr.size) {
            for (index in pass downTo 1) {
                if (arr[index] < arr[index - 1]) {
                    val temp = arr[index]
                    arr[index] = arr[index - 1]
                    arr[index - 1] = temp
                }
            }
        }
        Log.d("demoInsertionSort", "arr: ${arr.toList()}")
    }

    fun demoBubbleSort() {

        val arr = intArrayOf(15, 5, 6, 0, 4, 8, 1, 9, 2)
        val kth = arr.size

        if (kth <= 0 || kth > arr.size) {
            return
        }

        //var pass = arr.size - arr.size -k

        for (pass in arr.size downTo arr.size - kth) {
            for (index in 0 until pass - 1) {
                if (arr[index] > arr[index + 1]) {
                    val temp = arr[index]
                    arr[index] = arr[index + 1]
                    arr[index + 1] = temp
                }
            }
        }

        Log.d("demoBubbleSort", "arr: ${arr.toList()}, kth: $kth")
    }


    fun <T : InClass> functionIn(param: T) {

    }

    fun <T : InClass> function(param: T) {

    }

    fun sum(list: List<Number>): Double {
        var sum = 0.0
        for (n in list) {
            sum += n.toDouble()
        }
        return sum
    }

    fun demo() {
        Demo.functionIn(InClass())
        Demo.functionIn(InClassE())

        Demo.sum(arrayListOf(1, 2, 3))


        Dummy.sum(arrayListOf(1, 2, 3))


        Demo.check(InClassE())
        Demo.checkE(InClassE())
    }


    fun <T : InClass> check(param: T) {

    }

    fun <T : InClassE> checkE(param: T) {

    }
}

open class InClass {

}

class InClassE : InClass()