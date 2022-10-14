//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//https://leetcode.com/problemset/all?search=124

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
    private var maxSum = Int.MIN_VALUE

    private fun maxPathSumImpl(node: TreeNode?): Int {
        node ?: return 0
        val left = maxPathSumImpl(node.left)
        val right = maxPathSumImpl(node.right)
        maxSum = Math.max(maxSum, node.`val` + left + right)
        val s =  Math.max(Math.max(node.`val`, node.`val` + left), node.`val` + right)
        maxSum = Math.max(maxSum, s)
        return s
    }

    fun maxPathSum(root: TreeNode?): Int {
        maxPathSumImpl(root)
        return maxSum
    }
}
