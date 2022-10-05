/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val` */
// Definition for a binary tree node.
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class Solution {
    private fun maximumAverageSubtreeImpl(root: TreeNode, result: DoubleArray): Pair<Int, Int> {
        var n = 1
        var s = root.`val`
        var left = Pair(0, 0)
        var right = Pair(0, 0)
        var l = root.left
        var r = root.right
        if (l != null) {
            left = maximumAverageSubtreeImpl(l, result)
        }
        if (r != null) {
            right = maximumAverageSubtreeImpl(r, result)
        }
        n += left.second + right.second
        s += left.first + right.first
        result[0] = Math.max(result[0], s.toDouble() / n)
        return Pair(s, n)
    }

    fun maximumAverageSubtree(root: TreeNode?): Double {
        root ?: return 0.0
        val result = doubleArrayOf(0.0)
        maximumAverageSubtreeImpl(root, result)
        return result.first()
    }
}
fun main() {
	println(Solution().maximumAverageSubtree(
        TreeNode(5).apply {
            left = TreeNode(6)
            right = TreeNode(1)
        }
    ))
	println(Solution().maximumAverageSubtree(
        TreeNode(0).apply {
            right = TreeNode(1)
        }
    ))
	println(Solution().maximumAverageSubtree(
        TreeNode(0).apply {
            right = TreeNode(1).apply {
                right = TreeNode(0).apply {
                    left = TreeNode(0)
                }
            }
        }
    ))
	println(Solution().maximumAverageSubtree(null))
}
