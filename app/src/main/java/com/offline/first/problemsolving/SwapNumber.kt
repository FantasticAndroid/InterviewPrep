package com.offline.first.problemsolving

object SwapNumber {

    fun swapNumber( a: Int, b: Int){
        var first = a
        var second = b
        first = first xor second
        second = first xor second
        first = first xor second

        println("swapNumber a: $a, b:$b, first: $first, second: $second")
    }
}