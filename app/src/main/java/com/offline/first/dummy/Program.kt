package com.offline.first.dummy

import android.util.Log

object Program {

    // Find the length of longest substring without repeating characters


    // pwwkkew
        // 3
    fun findLength(string: String){

        val length: Int = if(string.isEmpty()){
            0
        }else{
            var counter = 1
            (0 until  string.length-1).forEach { index ->
                if(string[index] != string[index+1]){
                    counter++
                }else{
                    counter = 1
                }
            }
            counter
        }
        Log.d("GA", "string: $string, length: $length")
    }

}