package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "DecimalToConvertor"

object DecimalToConvertor {

    /**
     *
     * @param number Long
     * @param noSystem Int -> binary ->2 , Octal ->8 Hexadecimal -> 16
     */
    fun decimalToConvertor(number: Long, noSystem: Int) {
        val s = StringBuilder()
        if (noSystem == 2 || noSystem == 8) {
            var n = number
            while (n > 0L) {
                s.insert(0,n % noSystem)
                n /= noSystem
            }
        }else if(noSystem == 16){
            val hex = arrayOf('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F')
            var n = number
            while (n > 0L) {
                s.insert(0, hex[(n % noSystem).toInt()])
                n /= noSystem
            }
        }else{
            // Invalid
        }
        Log.d(TAG, "number: $number, noSystem: $noSystem, convert: $s")
    }
}