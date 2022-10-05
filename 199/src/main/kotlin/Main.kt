//https://leetcode.com/problemset/all?search=199
//https://leetcode.com/problems/binary-tree-right-side-view/

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
	private var level  = 0
	
	private fun rightSideViewImpl(
	node: TreeNode?,
	j: Int,
	result: MutableList<Int>
	) {
		node?: return
		if (j > level) {
			result.add(node.`val`)
		}
		rightSideViewImpl(node.right, j+1, result)
		rightSideViewImpl(node.left, j+1, result)
		level = Math.max(level, j)
	}
	fun rightSideView(root: TreeNode?): List<Int> {
		val result = mutableListOf<Int>()
		rightSideViewImpl(root, 1, result)
		return result
	}
}

fun main() {
}
