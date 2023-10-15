package com.offline.first.ds.list

import android.util.Log

private const val TAG = "DoublyLinkedListOpt"

object DoublyLinkedListOpt {

    class DoublyLinkedList() {

        var headNode: Node? = null

        /**
         *
         * @param item Int
         * @return New Head Node
         */
        fun insertOnHead(item: Int) {
            Log.d(TAG, "insertOnHead: item:$item")
            if (headNode == null) {
                headNode = Node(item)
            } else {
                val node = Node(item = item)
                headNode?.previous = node
                node.next = headNode
                headNode = node
            }
        }

        fun insertOnTail(item: Int) {
            Log.d(TAG, "insertOnTail: item:$item")
            if (headNode == null) {
                headNode = Node(item)
            } else {
                val tailNode = getTailNode()
                val node = Node(item = item)
                tailNode?.next = node
                node.previous = tailNode
            }
        }

        /**
         *
         * @param item Int
         * @param position Int
         */
        fun insertAt(item: Int, position: Int): Boolean {
            Log.d(TAG, "insertAt: item:$item, position: $position")
            return if (headNode != null) {
                var indexedNode: Node? = headNode
                for (index in 0 until position) {
                    indexedNode = indexedNode?.next
                }
                indexedNode?.let { node ->
                    val itemNode = Node(item)
                    itemNode.previous = indexedNode.previous
                    itemNode.next = indexedNode
                    indexedNode.previous = itemNode
                    true
                } ?: false
            } else
                false
        }

        /**
         *
         * @return New HeadNode
         */
        fun deleteFromHead(): Node? {
            Log.d(TAG, "deleteFromHead")
            return if (headNode != null) {
                headNode?.next?.let {
                    headNode = it
                } ?: run {
                    headNode = null
                }
                headNode
            } else
                null
        }

        fun deleteFromTail(): Node? {
            Log.d(TAG, "deleteFromTail")
            return if (headNode != null) {
                val tailNode = getTailNode()
                tailNode?.previous?.next = null
                tailNode
            } else {
                null
            }
        }

        fun traverseFromHead() {
            val list = ArrayList<Int>()
            var tailNode: Node? = headNode
            do {
                tailNode?.let {
                    list.add(it.item)
                    tailNode = it.next
                }
            } while (tailNode != null)
            Log.d(TAG, "traverseFromHead: $list")
        }

        fun traverseFromTail() {
            val list = ArrayList<Int>()
            var headNode: Node? = getTailNode()
            do {
                headNode?.let {
                    list.add(it.item)
                    headNode = it.previous
                }

            } while (headNode != null)
            Log.d(TAG, "traverseFromTail: $list")
        }

        fun getTailNode(): Node? {
            return if (headNode != null) {
                var tailNode = headNode
                while (tailNode?.next != null) {
                    tailNode = tailNode.next!!
                }
                tailNode
            } else
                null
        }
    }

    fun applyDoublyLinkedList() {
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)

        val doublyLinkedList = DoublyLinkedList()

        arr.forEach {
            doublyLinkedList.insertOnTail(it)
        }
        doublyLinkedList.traverseFromHead()

        arr.forEach {
            doublyLinkedList.insertOnHead(it)
        }
        doublyLinkedList.traverseFromHead()
        doublyLinkedList.traverseFromTail()

        doublyLinkedList.deleteFromHead()
        doublyLinkedList.deleteFromTail()

        doublyLinkedList.insertAt(10, 5)
    }
}