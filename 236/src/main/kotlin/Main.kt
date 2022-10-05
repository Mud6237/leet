//https://leetcode.com/problemset/all?search=236
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
/**
 * Definition for a binary tree node.
 */

 data class TreeNode(var `val`: Int = 0) {
	var left: TreeNode? = null
	var right: TreeNode? = null
 }

class Solution {
	data class RMQNode(
		val depth: Int,
		val treeNode: TreeNode
	)

	fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
		val nodes = mutableListOf<TreeNode>()
		val depths = mutableListOf<Int>()
		val stack = mutableListOf<TreeNode>()
		var node = root
		var pIndex = 0
		var qIndex = 0
		while(node != null) {
			while(node != null) {
				stack.add(node)
				node = node.left
			}
			while(stack.isNotEmpty() && node == null) {
				val depth = stack.lastIndex
				val top = stack.removeAt(stack.lastIndex)
				depths.add(depth)
				nodes.add(top)
				if (top === p) {
					pIndex = nodes.lastIndex
				}
				if (top === q) {
					qIndex = nodes.lastIndex
				}
				node = top.right
			}
		}
		var lcaNode: TreeNode? = null
		var minDepth = Int.MAX_VALUE
		for(i in Math.min(pIndex, qIndex)..Math.max(pIndex, qIndex)) {
			if (depths[i] < minDepth) {
				minDepth = depths[i]
				lcaNode = nodes[i]
			}
		}
		return lcaNode
	}
}