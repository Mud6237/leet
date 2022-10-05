// https://leetcode.com/problemset/all?search=124
// https://leetcode.com/problems/binary-tree-maximum-path-sum/
// https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/389609/Full-Explanation-article-with-pseudo-code-Beats-JAVA-100-time-and-100-space-Solution

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node. */
 
class TreeNode(var `val`: Int) {
		var left: TreeNode? = null
		var right: TreeNode? = null
}
 
class Solution {
	private fun maxPathSumImpl(node: TreeNode?, result: IntArray): Int {
		val n = node ?: return 0
		val l = maxPathSumImpl(node.left, result)
		val r = maxPathSumImpl(node.right, result)
		
		val p1 = node.`val`
		val p2 = node.`val` + l
		val p3 = node.`val` + r
		val p4 = node.`val` + l + r
		result[0] = Math.max(result[0], Math.max(Math.max(p1, p2) , Math.max(p3, p4)))
		val v = Math.max(Math.max(p1, p2), p3)
		return v
	}
	fun maxPathSum(root: TreeNode?): Int {
		val result = IntArray(1)
		maxPathSumImpl(root, result)
		return result.first()
	}
}

fun main(args: Array<String>) {
	val root = TreeNode(-10).apply {
		left = TreeNode(9)
		right = TreeNode(20).apply {
			left = TreeNode(15)
			right = TreeNode(7)
		}
	}
	println(Solution().maxPathSum(root))
	println(Solution().maxPathSum(TreeNode(90)))
}
