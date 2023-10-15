package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "ArmstrongImpl"

/**
 * A number is called an Armstrong number if it is equal to sum of its digits each raised to the power of number of digits in it.
 */
object ArmstrongImpl {

    fun findArmstrongNo(number: Long): Boolean {
        val isArmstrong = false

        val numberLength = number.toString().length

        var digit = number
        var armNumber: Long = 0L
        while (digit != 0L) {
            val lastDigit = digit % 10

            var power = lastDigit

            (1 until numberLength).forEach { _ ->
                power *= lastDigit
            }
            armNumber += power
            digit /= 10
        }

        Log.d(
            TAG,
            "findArmstrongNo number: $number, isArmstrong: ${number == armNumber}"
        )
        return isArmstrong
    }
}