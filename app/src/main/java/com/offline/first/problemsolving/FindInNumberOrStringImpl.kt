package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "FindInNumberOrStringImpl"

object FindInNumberOrStringImpl {

    /**
     * Find Positive number less than the smallest number in the array
     * [7, 8, 9, 11, 12] output = 6
     * [1, 2, 3, 4] output = 5
     * [1,2,4,8] output = 3
     * [-5,-6,0,8] output = 2
     * @param arr IntArray
     * @return Int
     */
    fun findMissingMinimumPositiveIntegerFromArray(arr: IntArray): Int {
        var pList = arr.filter { it > 0 }
        if (pList.isEmpty()) {
            return 1
        }

        println("First pList: ${pList.toList()}")
        pList = pList.sorted()
        println("Sort pList: ${pList.toList()}")

        if(pList[0]>1)
            return pList[0]-1

        for (index in 0 until pList.size - 1) {
            if (pList[index + 1] - pList[index] > 1){
                return pList[index] + 1
            }
        }
        return pList[pList.size-1] + 1
    }


    /**
     * [7, 8, 9, 11, 12] output = 1
     * [1, 2, 3, 4] output = 5
     * [1,2,4,8] output = 3
     * [-5,-6,0,8] output = 1
     * https://leetcode.com/problems/first-missing-positive/
     * @param arr IntArray
     * @return Int
     */
    fun findMissingSmallestPositiveIntegerFromArray(arr: IntArray): Int {
        var pList = arr.filter { it > 0 }
        if (pList.isEmpty()) {
            return 1
        }

        if(!pList.contains(1)){
            return 1
        }else{
            pList = pList.sorted()
            for (index in 0 until pList.size - 1) {
                if (pList[index + 1] - pList[index] > 1){
                    return pList[index] + 1
                }
            }
            return pList[pList.size-1] + 1
        }

        /*pList = pList.sorted()

        if(pList[0]!=1){
            return 1
        }else{
            for (index in 0 until pList.size - 1) {
                if (pList[index + 1] - pList[index] > 1){
                    return pList[index] + 1
                }
            }
            return pList[pList.size-1] + 1
        }*/
    }

    /**
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * Input: s = "dvdf"
     * Output: 3 (vdf)
     *
     * @param s String
     */
    fun findLongestSubStringWithoutRepeatingCharacters(s: String): Int {

        var leftIndex = 0
        var rightIndex = 0
        val visitedLetters = HashSet<Char>()
        var longest = 0
        while (rightIndex < s.length) {
            val char = s[rightIndex]

            if (!visitedLetters.contains(char)) {
                visitedLetters.add(char)
                longest = longest.coerceAtLeast(rightIndex - leftIndex + 1)
            } else {
                while (char != s[leftIndex]) {
                    visitedLetters.remove(s[leftIndex])
                    leftIndex++
                }
                leftIndex++
            }
            rightIndex++
        }
        visitedLetters.clear()
        Log.d(TAG, "findLongestSubString, input:$s, length: $longest")
        return longest
    }

    /**
     * From Bubble Sort
     * @param arr Array<Int>
     * @param n Int, For ex n = 3 , means third largest
     */
    fun findAnyLargestNoFromArrayBubbleSort(arr: Array<Int>, n: Int) {
        if (n <= 0 || n > arr.size) {
            Log.d(
                TAG,
                "findAnyLargestNoFromArrayBubbleSort arr size: ${arr.size}, n: $n, n is Invalid"
            )
            return
        }

        for (pass in (arr.size - 1) downTo (arr.size - n)) {
            for (index in 0 until pass) {
                if (arr[index + 1] < arr[index]) {
                    val temp = arr[index]
                    arr[index] = arr[index + 1]
                    arr[index + 1] = temp
                }
            }
        }

        Log.d(
            TAG,
            "findAnyLargestNoFromArrayBubbleSort arr: ${arr.toList()}, $n:thLargest: ${arr[arr.size - n]}"
        )
    }

    fun findAnySmallestNoFromArrayBubbleSort(arr: Array<Int>, n: Int) {
        if (n <= 0 || n > arr.size) {
            Log.d(
                TAG,
                "findAnySmallestNoFromArrayBubbleSort arr size: ${arr.size}, n: $n, n is Invalid"
            )
            return
        }

        for (pass in (arr.size - 1) downTo (arr.size - n)) {
            for (index in 0 until pass) {
                if (arr[index + 1] > arr[index]) {
                    val temp = arr[index]
                    arr[index] = arr[index + 1]
                    arr[index + 1] = temp
                }
            }
        }

        Log.d(
            TAG,
            "findAnySmallestNoFromArrayBubbleSort arr: ${arr.toList()}, $n:thSmallest: ${arr[arr.size - n]}"
        )
    }

    /**
     * From InsertionSort
     * @param arr Array<Int>
     * @param n Int, For ex n = 3 , means third smallest
     */
    fun findAnySmallestNoFromArraySort(arr: Array<Int>, n: Int) {
        if (n <= 0 || n > arr.size) {
            Log.d(
                TAG,
                "findAnySmallestNoFromArraySort arr size: ${arr.size}, n: $n, n is Invalid"
            )
            return
        }

        for (pass in 0 until n) {
            var sIndex = pass
            for (index in pass + 1 until arr.size) {
                if (arr[index] < arr[sIndex]) {
                    sIndex = index
                }
            }
            val temp = arr[sIndex]
            arr[sIndex] = arr[pass]
            arr[pass] = temp
        }

        Log.d(
            TAG,
            "findAnySmallestNoFromArraySort arr: ${arr.toList()}, $n:Smallest: ${arr[n - 1]}"
        )
    }

    /**
     * Find the nth largest number from Given array
     */
    fun findAnyLargestNoFromArray(array: IntArray, n: Int) {
        if (n > array.size) {
            Log.d(TAG, "findAnyLargestNoFromArray arr size: ${array.size}, n: $n, n is Invalid")
            return
        }

        val leftIndex = 0
        val rightIndex = array.size - 1
        doQuickSort(array.toMutableList(), leftIndex, rightIndex)
        Log.d(
            TAG,
            "findAnyLargestNoFromArray arr: ${array.toList()}}"
        )
    }

    private fun doQuickSort(array: MutableList<Int>, left: Int, right: Int) {
        if (left < right) {
            val partitionIndex = getPartitionIndex(array, left, right)
            doQuickSort(array, left, partitionIndex - 1)
            doQuickSort(array, partitionIndex + 1, right)
        }
    }

    private fun getPartitionIndex(array: MutableList<Int>, left: Int, right: Int): Int {

        //val pivot: Int = array[(left..right).random()]

        val pivot: Int = array[left]
        var hIndex = left + 1
        var sIndex = right

        do {
            while (array[hIndex] <= pivot) {
                hIndex++
            }
            while (array[sIndex] > pivot) {
                sIndex--
            }

            if (hIndex < sIndex) {
                val temp = array[hIndex]
                array[hIndex] = array[sIndex]
                array[sIndex] = temp
            }

        } while (hIndex < sIndex)

        val temp = array[sIndex]
        array[sIndex] = pivot
        array[left] = temp

        return sIndex
    }

    fun findAnyLargestNoFromArrayQuickSort(arr: Array<Int>, n: Int) {
        if (n <= 0 || n > arr.size) {
            Log.d(
                TAG,
                "findAnyLargestNoFromArrayForLoop arr size: ${arr.size}, n: $n, n is Invalid"
            )
            return
        }

        for (pass in (arr.size - 1) downTo (arr.size - n)) {
            for (index in 0 until pass) {
                if (arr[index + 1] < arr[index]) {
                    val temp = arr[index]
                    arr[index] = arr[index + 1]
                    arr[index + 1] = temp
                }
            }
        }

        Log.d(
            TAG,
            "findAnyLargestNoFromArrayForLoop arr: ${arr.toList()}, $n:thLargest: ${arr[arr.size - n]}"
        )
    }

    /**
     * find the largest number ‘L’ less than a given number ‘N’ which should not contain a given digit ‘D’.
     * If 145 is the given number and 4 is the given digit,
     * then you should find the largest number less than 145 such that it should not contain 4 in it.
     * Answer, 139
     * In below program, D is not given, so we find D as let D is the largest digit in the given number
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

    /**
     * Find sub array which total equal to the size of the array.
     * @param array Array<Int>
     */
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
    fun findStringIsRotated(sourceString: String, targetString: String): Boolean {
        val isRotated = if (sourceString.length != targetString.length) {
            false
        } else {
            (sourceString + sourceString).contains(targetString)
        }
        Log.d(
            TAG,
            "findStringIsRotated source: $sourceString, target: $targetString, isRotated: $isRotated"
        )
        return isRotated
    }

    fun findSecondLargestInArray(array: Array<Int>): Int {
        var max = array[0]
        var sMax = array[1]
        if (max < sMax) {
            val temp = max
            max = sMax
            sMax = temp
        }

        (2 until array.size).forEach { index ->
            if (array[index] > max) {
                sMax = max
                max = array[index]
            } else if (array[index] > sMax) {
                sMax = array[index]
            }
            Log.d(TAG, "find max:$max, sMax: $sMax")
        }
        Log.d(
            TAG,
            "findSecondLargestInArray array: ${array.toList()}, secondMax: $sMax"
        )
        return sMax
    }
}