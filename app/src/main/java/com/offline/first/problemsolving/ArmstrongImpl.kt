package com.offline.first.problemsolving

import android.util.Log
import kotlin.math.pow

private const val TAG = "ArmstrongImpl"

/**
 * A number is called an Armstrong number if it is equal to sum of its digits
 * each raised to the power of number of digits in it.
 */
object ArmstrongImpl {

    fun isArmstrongNo1(number: Long): Boolean {
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
            "findArmstrongNo1 number: $number, isArmstrong: ${number == armNumber}"
        )
        return isArmstrong
    }

    fun isArmstrongNo2(number: Long): Long {
        val length = number.toString().length
        var cNumber = number
        var sum = 0L
        while (cNumber > 0) {
            val digit = cNumber % 10
            sum += digit.toDouble().pow(length).toLong()
            cNumber /= 10
        }
        Log.d(
            TAG,
            "isArmstrongNo2 number: $number, isArmstrong: ${number == sum}"
        )
        return sum
    }
}