package com.offline.first.problemsolving

import android.util.Log

/**
 * Two strings are said to be anagram if they contain same set of characters but in different order.
 * For example, “Mother In Law” and “Hitler Woman” are anagrams.
 */
private const val TAG = "SumOfDigitsImpl"

object SumOfDigitsImpl {

    fun findSumOfDigits(number: Long): Long {
        var n = number
        var sum = 0L
        while (n != 0L) {
            sum += n % 10
            n /= 10
        }
        Log.d(TAG, "findSumOfDigits: number: $number, sum: $sum")
        readSumOfDigits(number)
        return sum
    }

    fun readSumOfDigits(number: Long) {
        Log.d(TAG, "readSumOfDigits: number: $number, sum: ${recursion(number)}")
    }

    private fun recursion(number: Long): Long {
        //Log.d(TAG, "recursion: number: $number")
        return if (number == 0L) {
            0
        } else {
            number % 10 + recursion(number/10)
        }
    }
}