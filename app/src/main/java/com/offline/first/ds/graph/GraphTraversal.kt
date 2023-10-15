package com.offline.first.ds.graph

import android.util.Log
import java.util.LinkedList
import java.util.Queue

private const val TAG = "GraphTraversal"

object GraphTraversal {

    /**
     * Map nodes to indexes from 0 to node count.
     * For ex: First Map is 0, second is 1 and so on, irrespective of their original value
     * @param nodeCount Total nodes present in this graph
     */
    class Graph(val nodeCount: Int) {

        val adjList: Array<LinkedList<Int>> = Array(nodeCount) {
            LinkedList<Int>()
        }

        /**
         *
         * @param visitedNode Int
         * @param connectedNode Int
         */
        fun insertEdge(visitedNode: Int, connectedNode: Int) {
            Log.d(TAG, "insertEdge visitedNode: $visitedNode, connectedNode: $connectedNode")
            adjList[visitedNode].add(connectedNode)  /* adding an edge to the adjacency list (edges are bidirectional in this example) */
        }
    }

    private fun bfsTraversal(graph: Graph) {
        val traverseList = ArrayList<Int>()

        val queue: Queue<Int> = LinkedList() // List of
        val nodeVisitStatus = Array(graph.nodeCount) {
            false
        }
        // Start with visiting the root node which is 0 as always
        queue.add(0)  /* root node is added to the top of the queue */
        nodeVisitStatus[0] = true

        while (!queue.isEmpty()) {
            queue.poll()?.let { currentVisitedNode ->
                traverseList.add(currentVisitedNode)
                val connectedNodesList = graph.adjList[currentVisitedNode]
                connectedNodesList.forEach { vNode ->
                    if (!nodeVisitStatus[vNode]) { // Check if node is not already visited
                        queue.add(vNode)
                        nodeVisitStatus[vNode] = true
                    }
                }
            }
        }
        Log.d(TAG, "bfsTraversal: $traverseList")
    }

    /**
     *
     * @param graph Graph
     */
    private fun dfsTraversal(graph: Graph) {
        val traverseList = ArrayList<Int>()

        val nodeVisitStatus = Array(graph.nodeCount) {
            false
        }
        // Start with visiting the root node which is 0 as always
        dfs(0, graph.adjList, nodeVisitStatus, traverseList)

        Log.d(TAG, "dfsTraversal: $traverseList")
    }

    /**
     *
     * @param visitedNode Int
     * @param adjList Array<LinkedList<Int>>
     * @param nodeVisitStatus Array<Boolean>
     * @param traverseList ArrayList<Int>
     */
    private fun dfs(
        visitedNode: Int,
        adjList: Array<LinkedList<Int>>,
        nodeVisitStatus: Array<Boolean>,
        traverseList: ArrayList<Int>
    ) {
        nodeVisitStatus[visitedNode] = true  /*Mark the current node as visited*/
        traverseList.add(visitedNode)
        adjList[visitedNode].listIterator().apply {
            while (hasNext()) {
                val node = next()
                if (!nodeVisitStatus[node]) {
                    dfs(node, adjList, nodeVisitStatus, traverseList)
                }
            }
        }
    }

    fun applyGraphTraversal() {

        val pairList = arrayOf(
            Pair(0, 1),
            Pair(0, 2),
            Pair(0, 3),
            Pair(1, 3),
            Pair(2, 4),
            Pair(3, 5),
            Pair(3, 6),
            Pair(4, 7),
            Pair(4, 5),
            Pair(3, 2))

        val graph = Graph(pairList.size)
        pairList.forEach { pair ->
            graph.insertEdge(pair.first, pair.second)
        }
        bfsTraversal(graph)
        dfsTraversal(graph)
    }
}