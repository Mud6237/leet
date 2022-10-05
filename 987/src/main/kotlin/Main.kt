// https://leetcode.com/problemset/all?search=987
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

import java.util.SortedSet
import java.util.TreeMap

//Definition for a binary tree node.
class TreeNode(var `val`: Int) {
	var left: TreeNode? = null
	var right: TreeNode? = null
}
 
class Solution {
	fun verticalTraversalImpl(root: TreeNode?, row: Int, col: Int, result: TreeMap<Int, SortedSet<Triple<Int, Int, Int>>>) {
		val node = root ?: return
		result
			.getOrPut(col, {
				sortedSetOf<Triple<Int, Int, Int>>(
					Comparator({ t1, t2 ->
						if (t1.first == t2.first) {
							if (t1.third == t2.third) {
								-1
							} else {
								t1.third - t2.third
							}
						}
						else {
							t1.first - t2.first
						}
					})
				)
			})
			.add(Triple(row, col, node.`val`))
		verticalTraversalImpl(node.left, row + 1, col-1, result)
		verticalTraversalImpl(node.right, row + 1,  col+1, result)
	}
	
	fun verticalTraversal(root: TreeNode?): List<List<Int>> {
		val result = TreeMap<Int, SortedSet<Triple<Int, Int, Int>>>()
		verticalTraversalImpl(root,0, 0, result)
		return result.entries.map{ entry -> entry.value.map { it.third }.toList() }
	}
}

fun main(args: Array<String>) {
	var root = TreeNode(3).apply {
		left = TreeNode(9)
		right = TreeNode(20).apply {
			left = TreeNode(15)
			right = TreeNode(7)
		}
	}
	var result = Solution().verticalTraversal(root)
	println(result)

	root = TreeNode(12).apply {
		left = TreeNode(2).apply {
			left = TreeNode(4)
			right = TreeNode(5)
		}
		right = TreeNode(3).apply {
			left = TreeNode(5)
			right = TreeNode(7)
		}
	}
	result = Solution().verticalTraversal(root)
	println(result)
}
