//https://leetcode.com/problemset/all?search=173
// https://leetcode.com/problems/binary-search-tree-iterator/
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
class BSTIterator(root: TreeNode?) {
	private val stack = mutableListOf<TreeNode>()
	private var node: TreeNode? = root
	
	private fun traverse(): TreeNode? {
		while(node != null) {
			stack.add(node!!)
			node  = node?.left
		}
		val top: TreeNode? = if (stack.isNotEmpty()) {
			stack.removeAt(stack.lastIndex) 
		} else {
			null
		}
		node = top?.right
		return top
	}
	
	fun next(): Int {
		return traverse()!!.`val`
	}

	fun hasNext(): Boolean {
		if (node != null || stack.isNotEmpty()) {
			return true
		}
		return false
	}
}