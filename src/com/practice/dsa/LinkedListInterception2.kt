package com.practice.dsa

object LinkedListInterception2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val lines = arrayOf(
            "A->B",
            "G->B",
            "B->C",
            "C->D",
            "D->E",
            "H->J",
            "J->F",
            "A, G, E",
            "H, A"
        )
        try {
            val results = evaluate(lines)
            for (result in results) {
                println(result)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

//    @Throws(InvalidOperationException::class)
    private fun evaluate(lines: Array<String>): List<String> {
        val graph: MutableMap<String, Node> = HashMap()
        val results: MutableList<String> = ArrayList()

        for (line in lines) {
            if (line.contains(",")) {
                var returnValue: String

                try {
                    val split = line.split(",").toTypedArray()
//                    val strings = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                    for (i in split.indices) {
                        val string = split[i]
                        split[i] = string.trim()
                    }
                    val b = checkLinkedListIntersection(split, graph)
                    returnValue = b.toString()
                } catch (ex: InvalidOperationException) {
                    if (ex.message == "Cycle detected.") {
                        returnValue = "Error Thrown!"
                    } else {
                        throw ex
                    }
                }
                results.add(returnValue)
            } else if (line.contains("->")) {
                val split = line.split("->").toTypedArray()
//                val splitStr = line.split("->".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val current = split[0].trim()
                val next = split[1].trim()

                // Check to see if the parent node already exists
                var nextNode = graph[next]
                if (nextNode == null) {
                    // If it doesn't, add it in so we can reference the object
                    nextNode = Node(next, null)
                    graph[next] = nextNode
                }

                // Check to see if the child node already exists
                val currentNode = graph[current]
                if (currentNode != null) {
                    // If it does, update the existing object
                    currentNode.next = nextNode
                } else {
                    graph[current] = Node(current, nextNode)
                }
            }
        }
        return results
    }

    @Throws(InvalidOperationException::class)
    private fun checkLinkedListIntersection(nodeGroup: Array<String>, graph: Map<String, Node>): Boolean {
        val allTraversedNodes: MutableSet<String> = HashSet()

        for (value in nodeGroup) {
            val currentTraversedNodes: MutableSet<String> = HashSet()

            var node: Node? = graph[value] ?: continue

            do {
                if (allTraversedNodes.contains(node!!.value)) {
                    return true
                }

                // Don't follow cycles
                if (node.next != null && currentTraversedNodes.contains(node.next!!.value)) {
                    throw InvalidOperationException("Cycle detected.")
                }

                allTraversedNodes.add(node.value)
                currentTraversedNodes.add(node.value)

                node = node.next
            } while (node != null)
        }

        return false
    }

    internal class Node(var value: String, var next: Node?)

    internal class InvalidOperationException(message: String?) : Exception(message)
}
