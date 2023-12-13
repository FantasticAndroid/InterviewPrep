package com.offline.first.problemsolving

object RotateArray {

    /**
     * Best Solution
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     *
     * Given an integer array arr,
     * Rotate the array to the right by rotation steps, where rotation is non-negative.
     * @param rotationCounter Int
     * @return IntArray
     */
    fun rotateArrayReturn(arr:IntArray, rotationCounter:Int): IntArray{
        val size = arr.size
        val rotatedArray = IntArray(size)

        if(arr.isNotEmpty() && rotationCounter >=0){
            val rCounter = rotationCounter%size
            var rIndex = 0
            // Take rIndex
            for(index in (size-rCounter)..<size){
                rotatedArray[rIndex] = arr[index]
                rIndex++
            }

            for(index in 0 until size-rCounter){
                rotatedArray[rIndex] = arr[index]
                rIndex++
            }

            /* If dont want to return
            for(index in arr.indices){
                arr[index] = rotatedArray[index]
            }*/
        }

        println("rotateArrayReturn counter: $rotationCounter, rotatedArray: ${rotatedArray.toList()}")

        return rotatedArray
    }

    /**
     * @param arr IntArray
     * @param rotation Int
     */
    fun rotateArray(arr: IntArray, rotation: Int) {

        if(arr.isNotEmpty() && rotation >=0){

            (1..rotation%arr.size).forEach { _ ->
                val last = arr[arr.size - 1]
                for (index in arr.size - 1 downTo 1) {
                    arr[index] = arr[index - 1]
                }
                arr[0] = last
                println("rotateArray: rotation: $rotation, arr: ${arr.toList()}")
            }
        }
        println("rotateArray: Result arr: ${arr.toList()}")
    }

    fun rotateArrayRecursion(arr: IntArray, rotation: Int){
        if(arr.isNotEmpty() && rotation >=0){
            val rotationK = rotation%arr.size
            println("rotateArrayRecursion rotationK: $rotationK")
            rotateR(arr, 0, arr.size -1 )
            rotateR(arr,0, rotationK -1)
            rotateR(arr, rotationK, arr.size -1)
        }
    }

    private fun rotateR(arr: IntArray, start: Int, end: Int) {
        println("rotateR I start: $start, end: $end, arr: ${arr.toList()}")
        var s = start
        var e = end
        while( s < e){
            val temp= arr[s]
            arr[s] = arr[e]
            arr[e] = temp
            s++
            e--
        }
        println("rotateR E start: $s, end: $e, arr: ${arr.toList()}")
    }


}