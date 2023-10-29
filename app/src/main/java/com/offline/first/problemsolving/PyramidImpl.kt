package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "PyramidImpl"

object PyramidImpl {

    fun showPyramid(noOfRows: Int) : String {
        //val reversed = reverseStringRecursion(string = string)
        val sBuilder = StringBuilder()
        (1..noOfRows).forEach { row ->
            (1..row).forEach { item ->
                sBuilder.append(" ".plus(item).plus(" "))
                //Log.d(TAG, "row: $row")
            }
            sBuilder.append("\n")
        }
        Log.d(TAG, "showPyramid: $sBuilder")
        return sBuilder.toString()
    }
}