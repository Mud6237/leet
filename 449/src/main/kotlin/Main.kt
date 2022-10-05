//https://leetcode.com/problemset/all?search=449
//https://leetcode.com/problems/serialize-and-deserialize-bst/
/**
 * Definition for a binary tree node. */
class TreeNode(var `val`: Int) {
	var left: TreeNode? = null
	var right: TreeNode? = null
}
class Codec() {
	companion object {
		fun<T> MutableList<T>.removeLastOrNull(): T? {
			if(isNotEmpty()) {
				return removeAt(lastIndex)
			}
			return null
		}
	}


	fun serializeImpl( node: TreeNode?, sb: StringBuilder) {
		if (node == null) {
			sb.append("null,")
			return
		}
		serializeImpl(node.left, sb)
		serializeImpl(node.right, sb)
		sb.append(node.`val`, ',')
	}

	fun serialize_(root: TreeNode?): String { 
		val sb = StringBuilder()
		serializeImpl(root, sb)
		return sb.toString()
	}

	// Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
      val sb = StringBuilder()
			val stack = mutableListOf<TreeNode>()
			var node = root
			while(node != null) {
				while(node != null) {
					stack.add(node)
					node = node.left
				}
				var lastRemoved: TreeNode? = null
				sb.append("null,")
				while(stack.isNotEmpty() && node == null) {
					val top = stack.last()
					if (top.right == null || top.right === lastRemoved ) {
						lastRemoved = stack.removeAt(stack.lastIndex)
						if (lastRemoved.right == null) {
							sb.append("null,")
						}
						sb.append(lastRemoved.`val`, ',')
						node = null
					} else {
						node = top.right
					}
				}
			}
			return sb.toString()  
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
			val nodes  = data
			.split(",")
			.filter({ it.isNotEmpty() })
			.map({ if(it == "null") null else TreeNode(it.toInt()) } )
			if (nodes.size < 1) {
				return null
			}
			val stack = mutableListOf<TreeNode?>()
			for(node in nodes) {
				node?.right = stack.removeLastOrNull()
				node?.left = stack.removeLastOrNull()
				stack.add(node)
			}
			return stack.removeAt(stack.lastIndex)
    }
}

fun main() {
	val tree1 = TreeNode(2).apply {
		left = TreeNode(1)
		right = TreeNode(3)
	}
	var codec = Codec()
	val s1 = codec.serialize(tree1)
	val s2 = codec.serialize(codec.deserialize(s1))
	println(s1 == s2)

	val tree2 = TreeNode(1).apply {
		right = TreeNode(2)
		left = TreeNode(3).apply {
			right = TreeNode(9)
			left = TreeNode(10)
		}
	}
	val s3 = codec.serialize(tree2)
	println(s3)
	println(codec.serialize_(tree2))
	val t3 = codec.deserialize(s3)
	println(t3?.`val`)
	println(t3?.right?.`val`)
	println(t3?.left?.`val`)
}
