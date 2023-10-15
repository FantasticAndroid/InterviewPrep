package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "FindNumberImpl"

object FindInNumberOrStringImpl {


    /**
     * find the largest number ‘L’ less than a given number ‘N’ which should not contain a given digit ‘D’.
     * If 145 is the given number and 4 is the given digit,
     * then you should find the largest number less than 145 such that it should not contain 4 in it.
     * Answer, 139
     * @param number Long
     */
    fun findGivenNumberImpl(number: Long) {

        if (number <= 0)
            return

        // Find largest number in given number
        var n = number
        val listOfDigits = ArrayList<Int>()

        while (n != 0L) {
            listOfDigits.add((n % 10).toInt())
            n /= 10
        }
        var maxDigit = listOfDigits[0]
        (1 until listOfDigits.size).forEach {
            if (listOfDigits[it] > maxDigit) {
                maxDigit = listOfDigits[it]
            }
        }
        var answer = number - 1

        for (index in answer downTo 0) {
            if (!index.toString().contains(maxDigit.toString())) {
                answer = index
                break
            }
        }
        Log.d(TAG, "findGivenNumberImpl number: $number, answer: $answer")
        findGivenNumberImpl(number = answer)
    }

    /**
     * find all pairs of elements in the given array whose sum is equal to the size of the array
     * @param array Array<Int>
     * Applying Brute-Force
     */
    fun findPairInArray(array: Array<Int>) {
        val pairList = ArrayList<Pair<Int, Int>>()
        array.forEachIndexed { index, item ->

            (index + 1 until array.size).forEach { nextIndex ->
                if (array[nextIndex] + item == array.size) {
                    pairList.add(Pair(item, array[nextIndex]))
                }
            }
            /*array.find { it == array.size - item }?.let { required ->
                pairList.add(Pair(item, required))
            }*/
        }
        Log.d(
            TAG,
            "findPairInArray array: ${array.toList()}, size: ${array.size}, pairList: $pairList"
        )
    }

    fun findSubArray(array: Array<Int>) {
        val subList = ArrayList<Int>()

        for (index in array.indices) {
            var total = array[index]
            subList.clear()
            subList.add(total)

            for (nextIndex in index + 1 until array.size) {
                total += array[nextIndex]
                if (total < array.size) {
                    subList.add(array[nextIndex])
                } else if (total == array.size) {
                    subList.add(array[nextIndex])
                    break
                } else {
                    break
                }
            }
            if (total == array.size) {
                break
            }
        }
        /*array.forEachIndexed { index, item ->
            subList.clear()
            var total = item
            subList.add(item)
            (index + 1 until array.size).forEach { nextIndex ->
                total += array[nextIndex]
                if (total < array.size) {
                    subList.add(array[nextIndex])
                } else if (total == array.size) {
                    subList.add(array[nextIndex])
                    return@forEachIndexed
                } else {
                    return@forEach
                }
            }
        }*/
        Log.d(TAG, "findSubArray array: ${array.toList()}, size: ${array.size}, subList: $subList")
    }

    fun removeDuplicate(array: Array<Int>) {
        val list = ArrayList<Int>()
        array.forEach {
            if (!list.contains(it)) {
                list.add(it)
            }
        }
        Log.d(TAG, "removeDuplicate array: ${array.toList()}, size: ${array.size}, ndList: $list")
        removeDuplicate(array.toMutableList())
    }

    fun removeDuplicate(list: MutableList<Int>) {
        Log.d(TAG, "removeDuplicate list: $list, size: ${list.size}")

        val iterator = list.iterator()
        var index = 0
        while (iterator.hasNext()) {
            val item = iterator.next()
            index++
            if (index < list.size) {
                if (list.subList(index, list.size).contains(item)) {
                    iterator.remove()
                    index--
                }
            }
        }

        /*
        list.forEachIndexed { index, item ->
            if (list.subList(index + 1, list.size).contains(item)) {
                list.removeAt(index)
            }
        }*/
        Log.d(TAG, "removeDuplicate ndList: ${list.toList()}, size: ${list.size}")
    }

    /**
     *
     * @param sourceString String
     * @param targetString String
     * @return Boolean
     */
    fun findStringIsRotated(sourceString: String, targetString: String): Boolean{
        val isRotated = if(sourceString.length != targetString.length){
            false
        }else{
            (sourceString + sourceString).contains(targetString)
        }
        Log.d(TAG, "findStringIsRotated source: $sourceString, target: $targetString, isRotated: $isRotated")
        return isRotated
    }
}