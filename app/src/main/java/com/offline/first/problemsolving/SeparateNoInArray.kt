package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "SeparateNoInArray"
object SeparateNoInArray {

    /**
     * You have to move 'separateNo' either to end of the array or bring them to beginning of the array.
     * @param array Array<Int>
     * @param separateNo Int, bring it beginning of the array
     */
    fun separateNoFromArray(array: Array<Int>, separateNo: Int){
        val list = array.toMutableList()

        val iterator = list.iterator()
        while (iterator.hasNext()){
            if(iterator.next() == separateNo) {
                iterator.remove()
            }
        }
        for(index in 1..(array.size - list.size)){
            list.add(0, separateNo)
        }
        Log.d(TAG, "separateNoFromArray array: ${array.toList()}, sList: $list")
    }
}