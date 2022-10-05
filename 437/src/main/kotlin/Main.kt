//https://leetcode.com/problemset/all?search=437
//https://leetcode.com/problems/path-sum-iii/
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

	private fun pathSumImpl(node: TreeNode?, targetSum: Int, nodeVals: MutableList<Int>, result: IntArray) {
		node ?: return
		nodeVals.add(node.`val`)
		var s = 0
		for(j in nodeVals.lastIndex downTo 0) {
			s += nodeVals[j]
			if (s == targetSum) {
				result[0] += 1
			}
		}
		pathSumImpl(node.left, targetSum, nodeVals, result)
		pathSumImpl(node.right, targetSum, nodeVals, result)
		nodeVals.removeAt(nodeVals.lastIndex)
	}

	fun pathSum(root: TreeNode?, targetSum: Int): Int {
		val result = intArrayOf(0)
		val nodeVals = mutableListOf<Int>()
		pathSumImpl(root, targetSum, nodeVals, result)
		return result.first()
	}
}
fun main() {
	println("Hello World!")
}
