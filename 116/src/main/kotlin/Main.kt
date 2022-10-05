//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/**
 * Definition for a Node. */

class Node(var `val`: Int) {
	var left: Node? = null
	var right: Node? = null
	var next: Node? = null
}

class Solution {
	companion object {
		fun levelOrder(root: Node?): List<String> {
			val result = mutableListOf<String>()
			var node = root
			while(node != null) {
				var n = node
				while(n != null) {
					result.add("${n.`val`}")
					n = n.next
				}
				result.add("#")
				node = node.left
			}
			return result
		}
	}

	fun connectImpl(node: Node?, sibling: Node?) {
		node ?: return
		node.left?.next = node.right
		node.right?.next = sibling?.left
		connectImpl(node.left, node.right)
		connectImpl(node.right, sibling?.left)
	}

	fun connect(root: Node?): Node? {
		connectImpl(root, null)
		return root
	}
}
