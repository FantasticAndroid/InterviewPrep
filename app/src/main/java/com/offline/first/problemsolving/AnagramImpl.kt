package com.offline.first.problemsolving

import android.util.Log

private const val TAG = "AnagramImpl"

/**
 * https://javaconceptoftheday.com/java-interview-programs-with-solutions/
 *
 * Two strings are said to be anagram if they contain same set of characters but in different order.
 * For example, “Mother In Law” and “Hitler Woman” are anagrams.
 */
object AnagramImpl {

    fun findAnagramWithStringBuilder(s1: String, s2: String): Boolean {

        val s = s1.replace(" ", "").lowercase()
        val t = s2.replace(" ", "").lowercase()

        if (s.length != t.length) {
            return false
        }

        val sb = StringBuilder(t)

        s.forEach {
            if (sb.isEmpty() || !sb.contains(it)) {
                return false
            } else {
                val index = sb.indexOf(it)
                if(index >=0)
                    sb.deleteCharAt(index)
                ////sb.replaceFirst(it.toString().toRegex(), "")
            }
            println("it: $it, sb: $sb")
        }
        return sb.isEmpty()
    }

    fun findAnagram(s: String, t: String): Boolean {

        val s1 = s.replace(" ", "").lowercase()
        val s2 = t.replace(" ", "").lowercase()

        if (s1.length != s2.length) {
            return false
        }

        //val sArr1 = s1.toCharArray()
        val st = s2.toCharArray().toMutableList()

        s1.forEach {
            if (st.isEmpty() || !st.contains(it)) {
                return false
            } else {
                st.remove(it)
            }
        }
        return st.isEmpty()
    }

    fun findAnagram1(s1: String, s2: String): Boolean {

        val string1 = s1.replace(" ", "").lowercase()
        val string2 = s2.replace(" ", "").lowercase()

        val isAnagram = if (string1.length != string2.length) {
            false
        } else if (string1 == string2) {
            true
        } else {
            val s1Sorted = string1.toCharArray().sortedArray()
            val s2Sorted = string2.toCharArray().sortedArray()
            var isEqual = true
            s1Sorted.forEachIndexed { index, item1 ->
                if (item1 != s2Sorted[index]) {
                    isEqual = false
                    return@forEachIndexed
                }
            }

            //Log.d(TAG, "findAnagram, s1Sorted: ${s1Sorted.toList()}, s2Sorted: ${s2Sorted.toList()}")
            isEqual
        }

        /*Log.d(
            TAG,
            "findAnagram string1: $s1, string2: $s2, isAnagram: $isAnagram"
        )*/
        //findAnagram2(s1, s2)
        return isAnagram
    }

    fun findAnagram2(s1: String, s2: String): Boolean {

        val string1 = s1.replace(" ", "").lowercase()
        val string2 = s2.replace(" ", "").lowercase()

        val isAnagram = if (string1.length != string2.length) {
            false
        } else if (string1 == string2) {
            true
        } else {
            val s1Sorted = string1.toList().sorted().toString()
            val s2Sorted = string2.toList().sorted().toString()

            Log.d(TAG, "findAnagram2, s1Sorted: $s1Sorted, s2Sorted: $s2Sorted")
            s1Sorted == s2Sorted
        }

        Log.d(
            TAG,
            "findAnagram2 string1: $s1, string2: $s2, isAnagram: $isAnagram"
        )
        return isAnagram
    }

    /**
     * findAnagram(arrayOf("eat","tea","tan","ate","nat","bat"))
     * Output: [[eat, tea, ate], [tan, nat], [bat]]
     * @param arr Array<String>
     */
    fun findAndGroupAnagram(arr: Array<String>) {
        val anagramMap = HashMap<String, ArrayList<String>>()
        arr.forEach { word ->
            val sortedWord = word.toList().sorted().toString()
            // val sortedWord = word.toCharArray().sortedArray().joinToString()
            if(!anagramMap.containsKey(sortedWord)){
                anagramMap.put(sortedWord, ArrayList<String>())
            }
            anagramMap.get(sortedWord)?.add(word)
        }
        Log.d(TAG, "findAndGroupAnagram anagramsGroup: ${anagramMap.values}")
    }

    val f : () -> String = {

        ""
    }

    /**
     * findAnagram(arrayOf("eat","tea","tan","ate","nat","bat"))
     * Output: [[eat, tea, ate], [tan, nat], [bat]]
     * @param arr Array<String>
     */
    fun findAnagram(arr: Array<String>){

        val outputArr = ArrayList<ArrayList<String>>()

        if(arr.isNotEmpty()){
            val traversedAnagrams = ArrayList<String>()

            arr.forEachIndexed{ index, item ->

                if(!traversedAnagrams.contains(item)){
                    val outputNext = ArrayList<String>()
                    outputNext.add(item)

                    for(iIndex in index + 1 until arr.size){

                        val next = arr[iIndex]

                        val sb = StringBuilder(next)

                        item.forEach{ c ->

                            if(sb.isEmpty() || !sb.contains(c)){
                                return@forEach
                            }else{
                                sb.deleteCharAt(sb.indexOf(c))
                            }
                        }

                        if(sb.isEmpty()){
                            outputNext.add(next)
                            traversedAnagrams.add(next)
                        }
                    }
                    outputArr.add(outputNext)
                }
            }
            traversedAnagrams.clear()
            println("FindAnagram: $outputArr")
        }
    }
}