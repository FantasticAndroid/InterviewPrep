package com.offline.first.ds.list

data class Node(val item: Int, var previous: Node? = null, var next: Node? = null)