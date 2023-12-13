package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "CharsInString"

object CharsInString {

    fun findDuplicateCharsInString(string: String) {

        val map = HashMap<Char, Int>()
        string.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        Log.d(TAG, "findDuplicateCharsInString map: ${map.filterValues { it > 1 }}")
    }

    fun findCharsInString(string: String) {

        val map = HashMap<Char, Int>()
        string.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        Log.d(TAG, "findCharsInString map: $map")
    }
}