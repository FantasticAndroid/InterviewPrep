package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "LeetCode"
object LeetCode {

    fun findBitwiseXORArray(pref: IntArray): IntArray {

        val output = IntArray(pref.size)
        output[0] = pref[0]

        for(index in 1 until pref.size){
            output[index] = pref[index-1].xor(pref[index])
        }
        Log.d(TAG, "findBitwiseXORArray, pref: ${pref.toList()}, output: ${output.toList()}")
        return output
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val output = ArrayList<Int>()

        for(i in 0 until nums.size){
            var sum = nums[i]
            output.clear()
            output.add(i)
            for(j in i+1 until nums.size){
                sum = sum + nums[j]
                if(sum < target){
                    output.add(j)
                } else if(sum > target){
                    break
                } else{
                    output.add(j)
                    break
                }
            }
            if(sum == target){
                break
            }
        }
        return output.toIntArray()
    }
}