package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "ArrayIntersectionImpl"
object ArrayIntersectionImpl {

    /**
     *
     * @param array1 Array<Int>
     * @param array2 Array<Int>
     */
    fun findCommonElementsIn(array1: Array<Int>, array2: Array<Int>) {
        val cList = HashSet<Int>()
        array1.forEach {
            if (array2.contains(it)) {
                cList.add(it)
            }
        }
        Log.d(TAG, "findCommonElementsIn array1: ${array1.toList()}, array2: ${array2.toList()}, common: $cList-")
    }
}