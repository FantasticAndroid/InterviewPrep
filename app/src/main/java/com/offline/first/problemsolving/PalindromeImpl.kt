package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "PalindromeImpl"

object PalindromeImpl {

    fun findPalindrome(number: Long) {
        val charArray = number.toString().toCharArray()
        var i = 0
        var j: Int = charArray.size - 1
        val mid = charArray.size / 2
        var isPalindrome = true

        while (i <= mid && j >= mid) {
            if (charArray[i] != charArray[j]) {
                isPalindrome = false
                break
            }
            i++
            j--
        }
        Log.d(TAG, "findPalindrome number: $number, isPalindrome: $isPalindrome")

    }

}