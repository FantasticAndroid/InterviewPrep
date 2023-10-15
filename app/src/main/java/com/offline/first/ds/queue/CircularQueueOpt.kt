package com.offline.first.ds.queue

import android.util.Log
import java.util.Queue

private const val TAG = "CircularQueueOpt"

object CircularQueueOpt {

    private class CircularQueue(private val sizeOfQueue: Int) {
        private val cQueue = Array<Int?>(sizeOfQueue) {
            null
        }

        private var front = -1
        private var rear = -1

        fun enQueue(element: Int): Boolean {
            Log.d(TAG, "enQueue start element: $element, front: $front, rear: $rear, cQueue: ${cQueue.toList()}")
            return if (front == -1 && rear == -1) {
                // Queue is empty
                front = 0
                rear = 0
                cQueue[rear] = element
                Log.d(TAG, "enQueued element: $element, front: $front, rear: $rear, cQueue: ${cQueue.toList()}")
                true
            } else {
                val r = (rear + 1) % sizeOfQueue
                if (r == front) {
                    // Queue is Full
                    Log.d(TAG, "Queue is Full element: $element, front: $front, rear: $rear, cQueue: ${cQueue.toList()}")
                    false
                } else {
                    rear = r
                    cQueue[rear] = element
                    Log.d(TAG, "enQueued element: $element, front: $front, rear: $rear, cQueue: ${cQueue.toList()}")
                    true
                }
            }
        }

        fun deQueue(): Int? {
            Log.d(TAG, "deQueue start front: $front, rear: $rear, cQueue: ${cQueue.toList()}")
            return if (front == -1 && rear == -1) {
                Log.d(TAG, "Queue is empty front: $front, rear: $rear, cQueue: ${cQueue.toList()}")
                null
            } else if (front == rear) {
                // Queue has only one element
                val element = cQueue[front]
                cQueue[front] = null
                front = -1
                rear = -1
                Log.d(TAG, "deQueue element: $element, front: $front, rear: $rear, cQueue: ${cQueue.toList()}")
                element
            } else {
                val element = cQueue[front]
                cQueue[front] = null
                front = (front + 1) % sizeOfQueue
                Log.d(TAG, "deQueue element: $element, front: $front, rear: $rear, cQueue: ${cQueue.toList()}")
                element
            }
        }

        fun traverse() {
            val traverseQueue = Array<Int?>(sizeOfQueue) {
                null
            }
            if (front == -1 && rear == -1) {
                Log.d(TAG, "Circular Queue is Empty")
            } else {
                var index = front
                var tIndex = 0

                while (index != rear) {
                    val element = cQueue[index]
                    traverseQueue[tIndex] = element
                    tIndex++
                    index = (index + 1) % sizeOfQueue
                }
                val element = cQueue[index]
                traverseQueue[tIndex] = element
            }
            Log.d(TAG, "traverse traverseQueue: ${traverseQueue.toList()}")
        }
    }

    fun applyCircularQueue() {
        val qrr = (1..5)
        val circularQueue = CircularQueue(qrr.count())
        qrr.forEach {
            circularQueue.enQueue(it)
        }
        //circularQueue.enQueue(10)

        circularQueue.deQueue()
        circularQueue.deQueue()
        circularQueue.deQueue()
        circularQueue.enQueue(10)
        circularQueue.enQueue(11)
        circularQueue.enQueue(12)
        circularQueue.enQueue(13)
        circularQueue.deQueue()
        /*(6..10).forEach {
            circularQueue.enQueue(it)
        }*/

        circularQueue.traverse()
    }
}
