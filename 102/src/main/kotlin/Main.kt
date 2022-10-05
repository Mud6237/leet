//https://leetcode.com/problemset/all?search=102
//https://leetcode.com/problems/binary-tree-level-order-traversal/
/**
 * Definition for a binary tree node.
 */
class TreeNode(var `val`: Int) {
	var left: TreeNode? = null
	var right: TreeNode? = null
}

class Solution {
	fun levelOrder(root: TreeNode?): List<List<Int>> {
		val result = mutableListOf<List<Int>>()
		root ?: return result
		var queue = mutableListOf<TreeNode>()
		queue.add(root)
		while(queue.isNotEmpty()) {
			var nextQueue = mutableListOf<TreeNode>()
			for(node in queue) {
				val left = node.left
				if (left != null) {
					nextQueue.add(left)
				}
				val right = node.right
				if (right != null) {
					nextQueue.add(right)
				}
			}
			result.add(queue.map{it.`val`})
			queue = nextQueue
		}
		return result
	}
}