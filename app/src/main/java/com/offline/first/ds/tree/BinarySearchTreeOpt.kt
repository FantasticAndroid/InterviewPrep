package com.offline.first.ds.tree

import android.util.Log

private const val TAG = "BinarySearchTree"

object BinarySearchTreeOpt {

    private class BinarySearchTree {

        private var rootNode: Node? = null

        private fun insertValue(parentNode: Node, valueToInsert: Int) {
            //Log.d(TAG, "insert valueToInsert: $valueToInsert, parentNode: $parentNode")
            if (valueToInsert < parentNode.item) {
                parentNode.left?.let { leftNode ->
                    insertValue(leftNode, valueToInsert = valueToInsert)
                } ?: run {
                    parentNode.left = Node(item = valueToInsert)
                }
            } else if (valueToInsert > parentNode.item) {
                parentNode.right?.let { rightNode ->
                    insertValue(rightNode, valueToInsert = valueToInsert)
                } ?: run {
                    parentNode.right = Node(item = valueToInsert)
                }
            }
        }

        fun insert(item: Int) {
            Log.d(TAG, "insert item: $item")
            rootNode?.let {
                insertValue(it, item)
            }
        }

        fun insertInBinaryTree(arr: Array<Int>) {
            Log.d(TAG, "insertInBinaryTree arr: ${arr.toList()}")
            rootNode = Node(item = arr[0]).let {
                for (index in 1 until arr.size) {
                    insertValue(it, arr[index])
                }
                it
            }
        }

        /**
         * PreOrder Root -> Left -> Right
         */
        private fun preOrderTraversal(readList: MutableList<Int>, rootNode: Node?) {
            rootNode?.apply {
                readList.add(rootNode.item)
                preOrderTraversal(readList, rootNode.left)
                preOrderTraversal(readList, rootNode.right)
            }
        }

        fun traverseByPreOrder(): List<Int> {
            Log.d(TAG, "traverseByPreOrder")
            val traversalList = mutableListOf<Int>()
            preOrderTraversal(traversalList, rootNode)
            return traversalList
        }

        /**
         * PostOrder Left -> Right -> Root
         */
        private fun postOrderTraversal(readList: MutableList<Int>, rootNode: Node?) {
            rootNode?.apply {
                postOrderTraversal(readList, left)
                postOrderTraversal(readList, right)
                readList.add(item)
            }
        }

        fun traverseByPostOrder(): List<Int> {
            Log.d(TAG, "traverseByPostOrder")
            val traversalList = mutableListOf<Int>()
            postOrderTraversal(traversalList, rootNode)
            return traversalList
        }

        /**
         * InOrder Left -> Root -> Right
         */
        private fun inOrderTraversal(readList: MutableList<Int>, rootNode: Node?) {
            rootNode?.apply {
                inOrderTraversal(readList, left)
                readList.add(item)
                inOrderTraversal(readList, right)
            }
        }

        fun traverseByInOrder(): List<Int> {
            Log.d(TAG, "traverseByInOrder")
            val traversalList = mutableListOf<Int>()
            inOrderTraversal(traversalList, rootNode)
            return traversalList
        }

        /*private fun inOrderTraversal(readList: MutableList<Int>, rootNode: MutableNode?) {
            rootNode?.apply {
                inOrderTraversal(readList, rootNode.left)
                readList.add(rootNode.item)
                inOrderTraversal(readList, rootNode.right)
            }
        }*/

        fun isThisBST() = isGivenBinaryTreeIsBinarySearchTree(rootNode)

        private fun isGivenBinaryTreeIsBinarySearchTree(rootNode: Node?): Boolean {
            return rootNode?.run {
                val isLeftOk = left?.let { leftNode ->
                    item > leftNode.item
                } ?: true

                val isAllOk = if (isLeftOk) {
                    right?.let { rightNode ->
                        item < rightNode.item
                    } ?: true
                } else {
                    false
                }
                /*Log.d(
                    TAG,
                    "isBST isLeftOk: $isLeftOk, isAllOk: $isAllOk, root: ${rootNode.item}, left: ${rootNode.left?.item}, right: ${rootNode.right?.item}"
                )*/
                return if (isAllOk) {
                    rootNode.left?.run {
                        isGivenBinaryTreeIsBinarySearchTree(this)
                    } ?: true

                    rootNode.right?.run {
                        isGivenBinaryTreeIsBinarySearchTree(this)
                    } ?: true
                } else {
                    false
                }
            } ?: false
        }

        private fun findSmallestNodeValue(rootNode: Node): Int {
            var smallest = rootNode.item

            rootNode.left?.let { lNode ->
                val min = findSmallestNodeValue(lNode)
                if (min < smallest) {
                    smallest = min
                }
            }

            rootNode.right?.let { rNode ->
                val min = findSmallestNodeValue(rNode)
                if (min < smallest) {
                    smallest = min
                }
            }
            //Log.d(TAG, "findSmallestNode node: ${rootNode.item}, smallest: $smallest")
            return smallest
        }

        fun findSmallest(): Int {
            Log.d(TAG, "findSmallest")
            return findSmallestNodeValue(rootNode!!)
        }

        private fun findLargestNode(rootNode: Node): Node {
            var largest = rootNode

            rootNode.left?.let { lNode ->
                val max = findLargestNode(lNode)
                if (max.item > largest.item) {
                    largest = max
                }
            }

            rootNode.right?.let { rNode ->
                val max = findLargestNode(rNode)
                if (max.item > largest.item) {
                    largest = max
                }
            }
            //Log.d(TAG, "findLargestNode node: ${rootNode.item}, largest: $largest")
            return largest
        }

        fun findLargest(): Node {
            Log.d(TAG, "findLargest")
            return findLargestNode(rootNode!!)
        }

        private fun searchNode(rootNode: Node?, node: Node): Node? {
            return rootNode?.run {
                if (item == node.item) {
                    rootNode
                } else {
                    searchNode(rootNode.left, node) ?: searchNode(rootNode.right, node)
                }
            }
        }

        fun search(item: Int): Node? {
            Log.d(TAG, "search item: $item")
            return searchNode(rootNode, Node(item))
        }

        fun delete(item: Int): Node? {
            Log.d(TAG, "delete: item: $item")
            return deleteNode(rootNode, item)
        }

        /**
         *
         * @param rootNode Node?
         * @param item Int
         * @return Node?
         */
        private fun deleteNodeFromBST(rootNode: Node?, item: Int, parentNode: Node?): Node? {
            return rootNode?.let { node ->

                if (node.left == null && node.right == null) {
                    if(parentNode?.left?.item == item){
                        parentNode?.left = null
                    }else if(parentNode?.right?.item == item){
                        parentNode?.right = null
                    }
                }
                Log.d(TAG, "deleteNode: item: $item, node: $node")
                if (item == node.item) {
                    // Node found
                    getInOrderPredecessorNode(node)?.let { inOrderPreNode ->
                        node.item = inOrderPreNode.item
                        node.left = deleteNodeFromBST(node.left, inOrderPreNode.item, node)
                    }
                } else if (item < node.item) {
                    // node is in Left Tree of root
                    node.left = deleteNodeFromBST(node.left, item, node)
                } else {
                    // node is in Right Tree of root
                    node.right = deleteNodeFromBST(node.right, item, node)
                }
                node
            }
        }

        /**
         *
         * @param rootNode Node?
         * @param item Int
         * @return Node?
         */
        private fun deleteNode(rootNode: Node?, item: Int): Node? {
            return rootNode?.let { node ->

                if (node.left == null && node.right == null) {
                    node.item = -1
                }
                Log.d(TAG, "deleteNode: item: $item, node: $node")
                if (item == node.item) {
                    // Node found
                    getInOrderPredecessorNode(node)?.let { inOrderPreNode ->
                        node.item = inOrderPreNode.item
                        node.left = deleteNode(node.left, inOrderPreNode.item)
                    }
                } else if (item < node.item) {
                    // node is in Left Tree of root
                    node.left = deleteNode(node.left, item)
                } else {
                    // node is in Right Tree of root
                    node.right = deleteNode(node.right, item)
                }
                node
            }
        }

        private fun getInOrderPredecessorNode(node: Node): Node? {
            var preRoot = node.left
            while (node.right != null) {
                preRoot = node.right
            }
            return preRoot
        }

        /**
         *
         * @param currentNode Node?
         * @param item Int
         * @param parentNode Node
         * @return Node?
         */
        private fun findParent(currentNode: Node?, item: Int, parentNode: Node): Node? {
            return currentNode?.let { node ->
                if (node.item == item) {
                    parentNode
                } else {
                    findParent(currentNode.left, item, parentNode)
                    findParent(currentNode.right, item, parentNode)
                }
            }
        }

        fun findParentNode(item: Int): Node? {
            return rootNode?.let { node ->
                findParent(node, item, node)
            }
        }
    }

    fun applyBinarySearchTree() {
        val arr = arrayOf(7, 11, 9, 2, 25, 4, 0, 15, -5, 12)

        BinarySearchTree().apply {
            insertInBinaryTree(arr)

            Log.d(TAG, "traverseByInOrder: ${traverseByInOrder()}")
            Log.d(TAG, "traverseByPreOrder: ${traverseByPreOrder()}")
            Log.d(TAG, "traverseByPostOrder: ${traverseByPostOrder()}")

            insert(3)
            insert(8)
            insert(16)

            Log.d(TAG, "search: ${search(-5)}")
            Log.d(TAG, "search: ${search(11)}")
            Log.d(TAG, "search: ${search(10)}")

            Log.d(TAG, "findSmallest: ${findSmallest()}")
            Log.d(TAG, "findLargest: ${findLargest()}")

            Log.d(TAG, "isThisBST: ${isThisBST()}")

            Log.d(TAG, "delete: Node: ${delete(-5)}")
            Log.d(TAG, "traverseByInOrder: ${traverseByInOrder()}")

            Log.d(TAG, "delete: Node: ${delete(9)}")
            Log.d(TAG, "traverseByInOrder: ${traverseByInOrder()}")
        }
    }
}