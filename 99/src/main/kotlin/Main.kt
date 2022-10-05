//https://leetcode.com/problemset/all?search=99
//https://leetcode.com/problems/recover-binary-search-tree/
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
	companion object {
		fun printNodes(l: List<TreeNode>) {
			for(n in l) {
				print("${n.`val`},")
			}
			println()
		}

		fun printTree(root: TreeNode?) {
			val stack = mutableListOf<TreeNode>()
			val orderedNodes = mutableListOf<TreeNode>()
			var node = root
			while(node != null) {
				while(node != null) {
					stack.add(node)
					node = node.left
				}
				while(stack.isNotEmpty() && node == null) {
					val top = stack.removeAt(stack.lastIndex)
					orderedNodes.add(top)
					node = top.right
				}
			}
			printNodes(orderedNodes)
		}
	}
	

	fun recoverTree(root: TreeNode?): Unit {
		val stack = mutableListOf<TreeNode>()
		val orderedNodes = mutableListOf<TreeNode>()
		var node = root
		while(node != null) {
			while(node != null) {
				stack.add(node)
				node = node.left
			}
			while(stack.isNotEmpty() && node == null) {
				val top = stack.removeAt(stack.lastIndex)
				orderedNodes.add(top)
				node = top.right
			}
		}
		var previousNode = orderedNodes.first()
		var j = 0
		var k = 0
		for(i in 1 until orderedNodes.size) {
			if (previousNode.`val` > orderedNodes[i].`val`) {
				j = i - 1
				k = j
				var p = j
				while(p < orderedNodes.size) {
					if(orderedNodes[p].`val` < orderedNodes[k].`val`) {
						k = p
					}
					p += 1
				}
				break
			}
			previousNode = orderedNodes[i]
		}
		val t = orderedNodes[j].`val`
		orderedNodes[j].`val` = orderedNodes[k].`val`
		orderedNodes[k].`val` = t
	}
}

fun main() {
	
	val tree1 = TreeNode(1).apply {
		left = TreeNode(3).apply {
			right = TreeNode(2)
		}
	}
	Solution.printTree(tree1)
	Solution().recoverTree(tree1)
	Solution.printTree(tree1)

	val tree2 = TreeNode(3).apply {
			left = TreeNode(1)
			right = TreeNode(4).apply {
				left = TreeNode(2)
			}
		}
	Solution().recoverTree(tree2)
	Solution.printTree(tree2)
	val tree3 = TreeNode(1).apply {
		left = TreeNode(2)
		right = TreeNode(3)
	}
	Solution.printTree(tree3)
	Solution().recoverTree(tree3)
	Solution.printTree(tree3)
}
