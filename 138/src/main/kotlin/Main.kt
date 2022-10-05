//https://leetcode.com/problemset/all/?search=138
//https://leetcode.com/problems/copy-list-with-random-pointer/

/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 */

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class Solution {
    companion object {
        fun toArrayList(head: Node?): List<List<Int?>> {
            val result = mutableListOf<List<Int?>>()
            val h = hashMapOf<Node, Int>()
            var node = head
            var i = 0
            var r = mutableListOf<Node>()
            while(node != null) {
                r.add(node)
                h[node] = i
                node = node.next
                i += 1
            }
            for(n in r) {
                result.add(listOf(n.`val`, h[n.random]))
            }
            return result
        }
    }

    fun copyRandomList(head: Node?): Node? {
        var h = hashMapOf<Node, Node>()
        var beforeHead = Node(-1)
        var prev: Node? = beforeHead
        var node = head
        while(node != null) {
            var nodeVal = node.`val`
            val newNode = h.getOrPut(node, { Node(nodeVal) })
            val random = node.random
            if (random != null) {
                val newRandom = h.getOrPut(random, { Node(random.`val`) })
                newNode.random = newRandom
            }
            prev?.next = newNode
            prev = prev?.next
            node = node.next
        }
        return beforeHead.next
    }
}