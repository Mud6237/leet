//https://leetcode.com/problemset/all/?search=623
//https://leetcode.com/problems/add-one-row-to-tree/

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
	fun addOneRowImpl(node: TreeNode?, d: Int, v: Int, depth: Int) {
		node ?: return
		if (d == depth - 1) {
			val left = TreeNode(v)
			val right = TreeNode(v)
			
			left.left = node.left
			right.right = node.right

			node.left = left
			node.right = right
			return
		}
		addOneRowImpl(node.left, d + 1, v, depth)
		addOneRowImpl(node.right, d + 1, v, depth)
	}

    fun addOneRow(root: TreeNode?, v: Int, depth: Int): TreeNode? {
		if (depth == 1) {
			return TreeNode(v).apply { left = root }
		}
		addOneRowImpl(root, 1, v, depth)
		return root
    }
}


fun main() {
	println("Hello World!")
}
