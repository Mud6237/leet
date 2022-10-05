//https://leetcode.com/problems/validate-binary-search-tree/
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
	fun isValidBST(root: TreeNode?): Boolean {
		val stack = mutableListOf<TreeNode>()
		var node = root
		var prev:TreeNode? = null
		while(node != null) {
			while(node != null) {
				stack.add(node)
				node = node.left
			}
			while(stack.isNotEmpty() && node == null) {
				val top = stack.removeAt(stack.lastIndex)
				if (prev != null && prev.`val` >= top.`val`) {
					return false
				}
				node = top.right
				prev = top
			}
		}
		return true
	}
}