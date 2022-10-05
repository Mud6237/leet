/**
 * Definition for a binary tree node.
 */
class TreeNode(var `val`: Int = 0) {
	var left: TreeNode? = null
	var right: TreeNode? = null
}

class Solution {		
	fun nodesAtDistance(node: TreeNode?, d: Int, k: Int, result: MutableList<Int>) {
		node ?: return
		if (d >= k) {
			if (d == k) {
				result.add(node.`val`)
			}
			return
		}
		nodesAtDistance(node.left,  d + 1, k, result)
		nodesAtDistance(node.right, d + 1, k, result)
	}

	fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
		val result = mutableListOf<Int>()
		if (k == 0 && target != null) {
			result.add(target.`val`)
			return result
		}
		val stack = mutableListOf<TreeNode>()
		var node = root
		outer@while(node != null) {
			while(node != null) {
				if (node === target) {
					break@outer
				}
				stack.add(node)
				node = node.left
			}
			var lastRemoved: TreeNode? = null
			while(stack.isNotEmpty() && node == null) {
				val top = stack.last()
				if (top.right == null || top.right === lastRemoved) {
					lastRemoved =  stack.removeAt(stack.lastIndex)
					node = null
				} else {
					node = top.right
				}
			}
		}
		nodesAtDistance(target?.left, 1, k, result)
		nodesAtDistance(target?.right, 1, k, result)
		var d = 1
		var prev: TreeNode? = target
		//println("stack.size = ${stack.size}")
		while(stack.isNotEmpty()) {
			var n = stack.removeAt(stack.lastIndex)
			if (d == k) {
				result.add(n.`val`)
			}
			if (prev === n.left) {
				nodesAtDistance(n.right, d + 1, k, result)
			} else if (prev === n.right) {
				nodesAtDistance(n.left, d + 1, k, result)
			}
			prev = n
			d += 1
		}
		return result.toList()
	}
}