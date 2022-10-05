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
    fun boundaryOfBinaryTree(root: TreeNode?): List<Int> {
        root ?: return emptyList<Int>()
        var leftBoundary = mutableListOf<Int>()
        var node = root.left
        while(node?.left != null || node?.right != null) {
            leftBoundary.add(node.`val`)
            node = node.left ?: node.right
        }
        node = root.right
        var rightBoundary = mutableListOf<Int>()
        while(node?.right != null || node?.left != null) {
            rightBoundary.add(node.`val`)
            node = node.right ?: node.left
        }
        var stack = mutableListOf<TreeNode>()
        val leaves = mutableListOf<Int>()
        var n = root
        while(n != null) {
            while(n != null) {
                stack.add(n)
                n = n.left
            }
            while(stack.isNotEmpty() && n == null) {
                val t = stack.removeAt(stack.lastIndex)
                n = t.right
                if (t.left == null && t.right == null) {
                    leaves.add(t.`val`)
                }
            }
        }
        val self = if ((root.left ?: root.right) == null) emptyList<Int>() else listOf(root.`val`)
        return  self + leftBoundary + leaves + rightBoundary.reversed()
    }
}
fun main() {
    println(Solution().boundaryOfBinaryTree(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5).apply {
                left = TreeNode(7)
                right = TreeNode(8)
            }
        }
        right = TreeNode(3).apply {
            left = TreeNode(6).apply {
                left = TreeNode(9)
                right = TreeNode(10)
            }
        }
    }))
    println(Solution().boundaryOfBinaryTree(null))
    println(Solution().boundaryOfBinaryTree(TreeNode(1)))
    println(Solution().boundaryOfBinaryTree(TreeNode(1).apply {
        left = TreeNode(2)
    }))
    println(Solution().boundaryOfBinaryTree(TreeNode(1).apply {
        right = TreeNode(3)
    }))
    println(Solution().boundaryOfBinaryTree(TreeNode(1).apply {
        right = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(4)
        }
    }))
    println(Solution().boundaryOfBinaryTree(TreeNode(1).apply {
        right = TreeNode(2).apply {
            right = TreeNode(3).apply {
                right = TreeNode(4).apply {
                    right = TreeNode(5)
                }
            }
        }
    }))
    println(Solution().boundaryOfBinaryTree(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(5)
                }
            }
        }
        right = TreeNode(6).apply {
            right = TreeNode(7)
        }
    }))
}
