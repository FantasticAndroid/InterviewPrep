package com.offline.first.problemsolving

import kotlin.math.pow

object LinkListNode {

    private data class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private fun getLinkedList(array: IntArray): ListNode {
        val listNode = ListNode(array[0])
        var current = listNode
        for (index in 1 until array.size) {
            val next = ListNode(array[index])
            current.next = next
            current = next
        }
        return listNode
    }

    /**
     * https://leetcode.com/problems/add-two-numbers/
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     * Example 1:
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.

     * Example 2:
     * Input: l1 = [0], l2 = [0]
     * Output: [0]

     * Example 3:
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     */
    fun main() {

        val l1 = getLinkedList(intArrayOf(2, 4, 3))
        val l2 = getLinkedList(intArrayOf(5, 6, 4))
        val outputArray = ArrayList<Int>()
        addTwoNumbers(l1, l2)?.let { output ->
            outputArray.add(output.`val`)
            var nextNode = output.next

            while (nextNode != null) {
                outputArray.add(nextNode.`val`)
                nextNode = nextNode.next
            }
        }
        print("outputArray: $outputArray")
    }

    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var node1 : ListNode? = l1
        var node2 : ListNode? = l2
        var carry = 0

        val outputList = ListNode(0)
        var dummyList = outputList

        while (node1 != null || node2 != null || carry != 0) {

            val sum = (node1?.`val` ?: 0) + (node2?.`val` ?: 0) + carry
            val node = ListNode(sum % 10)
            carry = sum/10
            dummyList.next = node
            dummyList = node

            node1 = node1?.next
            node2 = node2?.next
        }

        val resultList = outputList.next
        outputList.next = null

        return resultList
    }

    private fun addTwoNumbersWithReverse(l1: ListNode, l2: ListNode): ListNode {

        var node1 = l1
        var node2 = l2
        var val1 = l1.`val`.toLong()
        var val2 = l2.`val`.toLong()
        var digitPow1 = 1
        var digitPow2 = 1
        //var final1 : Long =
        //var final2 : Long = 0L
        while (node1.next != null || node2.next != null) {
            node1.next?.let { node ->
                val1 += node.`val` * (10.0.pow(digitPow1)).toLong()
                digitPow1++
                node1 = node
            }
            node2.next?.let { node ->
                val2 += node.`val` * (10.0.pow(digitPow2)).toLong()
                digitPow2++
                node2 = node
            }
        }
        var finalSum = val1 + val2
        println("val1: $val1, val2: $val2, finalSum: $finalSum")

        val outputList = ListNode((finalSum % 10).toInt())
        var currentNode = outputList
        finalSum /= 10
        while (finalSum != 0L) {
            val nextNode = ListNode((finalSum % 10).toInt())
            currentNode.next = nextNode
            currentNode = nextNode
            finalSum /= 10
        }
        return outputList
    }

}