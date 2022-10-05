//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
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
				var next = node
				while(n != null) {
					result.add("${n.`val`}")
					if ((next?.left ?: next?.right) == null) {
						next = n
					}
					n = n.next
				}
				node = next?.left ?: next?.right
				result.add("#")
			}
			return result
		}
	}

	fun isNotNullOrLeaf(node : Node?): Boolean {
		return node?.left ?: node?.right != null
	}

	fun connectImpl(node: Node?, sibling: Node?) {
		node ?: return
		node.left?.next = node.right ?: sibling?.left  ?: sibling?.right
		node.right?.next = sibling?.left ?: sibling?.right
		//println("node = ${node.`val`} , sibling = ${sibling?.`val`}")
		var rightSibling: Node? = null
		var right = sibling?.left ?: sibling?.right
		while(right != null) {
			if (isNotNullOrLeaf(right)) {
				rightSibling = right
				break
			}
			right = right.next
		}
		connectImpl(node.right, rightSibling)
		var leftSibling: Node? = null
		var left = node.right ?: rightSibling
		while(left != null) {
			if (isNotNullOrLeaf(left)) {
				leftSibling = left
				break
			}
			left = left.next
		}
		//println("node = ${node.`val`} leftSibling = ${leftSibling?.`val`}")
		connectImpl(node.left, leftSibling)
	}

	fun connect(root: Node?): Node? {
		connectImpl(root, null)
		return root		
	}
}