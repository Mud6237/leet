//https://leetcode.com/problemset/all?search=113
//https://leetcode.com/problems/path-sum-ii/

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
	fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
		val stack = mutableListOf<Pair<TreeNode, Int>>()
		val result = mutableListOf<List<Int>>()
		var node = root
		while(node != null) {
			while(node != null) {
				val s = if (stack.isEmpty()) 0 else stack.last().second
				stack.add(node to (node.`val` + s))
				node = node.left
			}
			var lastRemoved: TreeNode? = null
			while(stack.isNotEmpty() && node == null) {
				var (top, pathSum) = stack.last()
				if (top.right == null || top.right === lastRemoved) {
					if (top.right == null && top.left == null && pathSum == targetSum) {
						result.add(stack.map{ it.first.`val`})
					}
					stack.removeAt(stack.lastIndex)
					lastRemoved = top
				} else {
					node = top.right
				}
			}
		}
		return result
	}
}