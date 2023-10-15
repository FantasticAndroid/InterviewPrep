package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "AnagramImpl"

/**
 * Two strings are said to be anagram if they contain same set of characters but in different order.
 * For example, “Mother In Law” and “Hitler Woman” are anagrams.
 */
object AnagramImpl {

    fun findAnagram(s1: String, s2: String): Boolean {

        val string1 = s1.replace(" ", "").lowercase()
        val string2 = s2.replace(" ", "").lowercase()

        val isAnagram = if (string1.length != string2.length) {
            false
        } else if (string1 == string2) {
            true
        } else {
            val s1Sorted = string1.toCharArray().sortedArray()
            val s2Sorted = string2.toCharArray().sortedArray()
            var isEqual = true
            s1Sorted.forEachIndexed { index, item1 ->
                if(item1 != s2Sorted[index]){
                    isEqual = false
                    return@forEachIndexed
                }
            }

            Log.d(TAG, "findAnagram, s1Sorted: ${s1Sorted.toList()}, s2Sorted: ${s2Sorted.toList()}")
            isEqual
        }

        Log.d(
            TAG,
            "findAnagram string1: $s1, string2: $s2, isAnagram: $isAnagram"
        )
        findAnagram2(s1, s2)
        return isAnagram
    }

    fun findAnagram2(s1: String, s2: String): Boolean {

        val string1 = s1.replace(" ", "").lowercase()
        val string2 = s2.replace(" ", "").lowercase()

        val isAnagram = if (string1.length != string2.length) {
            false
        } else if (string1 == string2) {
            true
        } else {
            val s1Sorted = string1.toList().sorted().toString()
            val s2Sorted = string2.toList().sorted().toString()

            Log.d(TAG, "findAnagram2, s1Sorted: $s1Sorted, s2Sorted: $s2Sorted")
            s1Sorted == s2Sorted
        }

        Log.d(
            TAG,
            "findAnagram2 string1: $s1, string2: $s2, isAnagram: $isAnagram"
        )
        return isAnagram
    }
}