package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "StringReverseImpl"

object StringReverseImpl1 {

    fun reverseString(string: String) {
        //val reversed = reverseStringRecursion(string = string)
        Log.d(TAG, "StringReverseImpl1 reversed: ${reverseStringRecursion(string = string)}")
    }

    fun reverseStringRecursion(string: String): String {
        Log.d(TAG, "StringReverseImpl1 string: $string, length: ${string.length}")
        return if (string.isEmpty()) {
            string
        } else {
            reverseStringRecursion(string.substring(1)) + string[0]
        }
    }
}

object StringReverseImpl2 {

    fun reverseString(string: String) {
        val length = string.length
        val reversed = CharArray(length)
        reverseStringRecursion(string, reversed, length - 1)
        Log.d(TAG, "StringReverseImpl2 reversed: ${reversed.concatToString()}")
    }

    private fun reverseStringRecursion(string: String, reversed: CharArray, index: Int) {
        if (index < 0) {
            return
        }
        reversed[reversed.size - index - 1] = string[index]
        reverseStringRecursion(string, reversed, index - 1)
    }
}

object StringReverseImpl3{

    fun reverseWordsInString(string: String){
        val words = string.split(" ")
        val stringBuilder  = StringBuilder()
        words.forEach{
            stringBuilder.append(StringReverseImpl1.reverseStringRecursion(it))
            stringBuilder.append(" ")
        }
        stringBuilder.trim()
        Log.d(TAG, "reverseWordsInString string: $string, reversed: $stringBuilder")
    }

}