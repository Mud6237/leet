//https://leetcode.com/problemset/all?search=103
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 */
class TreeNode(var `val`: Int) {
	var left: TreeNode? = null
	var right: TreeNode? = null
}

class Solution {
	fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
		root ?: return emptyList<List<Int>>()
		var queue = ArrayDeque<TreeNode>()
		var result = mutableListOf<List<Int>>()
		queue.addLast(root)
		var rightToLeft = false
		while(queue.isNotEmpty()) {
			var level = mutableListOf<Int>()
			val nextQueue = ArrayDeque<TreeNode>()
			repeat(queue.size) {
				val node = if (rightToLeft) queue.removeLast() else queue.removeFirst()
				level.add(node.`val`)
				val left = node.left
				var right = node.right
				if (rightToLeft) {
					if (right != null) {
						nextQueue.addFirst(right)
					}
					if (left != null) {
						nextQueue.addFirst(left)
					}
				} else {
					if (left != null) {
						nextQueue.addLast(left)
					}
					if (right != null) {
						nextQueue.addLast(right)
					}
				}
			}
			queue = nextQueue
			rightToLeft = !rightToLeft
			result.add(level)
		}
		return result
	}
}
