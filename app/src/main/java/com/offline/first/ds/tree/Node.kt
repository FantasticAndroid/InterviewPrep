package com.offline.first.ds.tree

//sealed class TreeNode(item: Int)

data class Node(var item: Int, var left: Node? = null, var right: Node? = null) //: TreeNode(item)
/*data class MutableNode(
    var item: Int,
    var left: MutableNode? = null,
    var right: MutableNode? = null
) :
    TreeNode(item)*/
