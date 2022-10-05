// https://leetcode.com/problemset/all?search=297



// Definition for a binary tree node.
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Codec() {
		private fun serializeImpl(root: TreeNode?): String {
			var r: TreeNode? = root ?: return "null"
			val sb = StringBuilder()
			val stack = mutableListOf<TreeNode>()
			var i = 0
			while(r != null) {
				while (r != null) {
					stack.add(r)
					r = r.left
				}
				sb.append("null,")
				var lastRemoved: TreeNode? = null
				while (stack.isNotEmpty()) {
					val n = stack.last()
					if (n.right != null && n.right != lastRemoved) {
						r = n.right
						break
					} else {
						lastRemoved = stack.removeLast()
						if(lastRemoved.right == null) {
							sb.append("null,")
						}
						sb.append(lastRemoved.`val`, ",")
					}
				}
			}
			return sb.toString()
		}

		// Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
      return serializeImpl(root)  
    }

		// Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
			val nodes = data
				.split(",")
				.filter{ it.isNotEmpty() }
				.map{ if (it =="null") null else TreeNode(it.toInt())}
			val stack = mutableListOf<TreeNode?>()
			for(node in nodes) {
				node?.right = stack.removeLastOrNull()
				node?.left = stack.removeLastOrNull()
				stack.add(node)
			}
			return stack.last()
    }
}

fun main(args: Array<String>) {
	val r = TreeNode(1)
	r.left = TreeNode(2)
	r.right = TreeNode(3)
	r.right?.left = TreeNode(4)
	r.right?.right = TreeNode(5)
	val s = Codec().serialize(r)
	println(Codec().serialize(Codec().deserialize(s)) == s)
}
