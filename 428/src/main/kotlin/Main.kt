// https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
/**
 * Definition for a Node.*/
class Node(var `val`: Int, var children: List<Node?> = listOf()) {
}

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: Node?): String {
        val sb = StringBuilder()
        val stack = mutableListOf<Pair<Node, Int>>()
        var n = root
        while(n != null) {
            while(n != null) {
                stack.add(Pair(n, 0))
                n = n.children.firstOrNull()
            }
            while(stack.isNotEmpty() && n == null) {
                val (t, c) = stack.last()
                var i = c + 1
                while( i < t.children.size && n == null) {
                    n = t.children[i]
                    i = i + 1
                }
                if (n == null) {
                    val (top) = stack.removeLast()
                    sb.append(top.`val`, ",", top.children.size, ",")    
                } else {
                    stack[stack.lastIndex] = Pair(t, i-1)
                }
            }
        }
        return sb.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): Node? {
        val input = data
            .split(",")
            .filter{ it.isNotEmpty() }
            .map { it.toInt()}
        if (input.size < 2) {
            return null
        }
        val stack = mutableListOf<Node>()
        for(i in 0 until input.lastIndex step 2) {
            var count = input[i+1]
            var childrenList = MutableList<Node?>(count, { null })
            for(j in count - 1 downTo 0) {
                childrenList[j] = stack.removeLast()
            }
            stack.add(Node(input[i], childrenList))
        }
        return stack.removeLast()
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var data = obj.serialize(root)
 * var ans = obj.deserialize(data)
 */
fun main() {
    val tree = Node(1).apply {
        children = listOf(
            Node(2),
            Node(3).apply {
                children = listOf(
                    Node(6),
                    Node(7).apply {
                        children = listOf(
                            Node(11).apply {
                                children = listOf(
                                    Node(14)
                                )
                            }
                        )
                    }
                )
            },
            Node(4).apply {
                children = listOf(
                    Node(8).apply {
                        children = listOf(
                            Node(12)
                        )
                    }
                )
            },
            Node(5).apply {
                children = listOf(
                    Node(9).apply {
                        children = listOf(
                            Node(13)
                        )
                    },
                    Node(10)
                )
            }
        )
    }
    val c = Codec()
    println(c.serialize(tree))
    println(c.serialize(c.deserialize(c.serialize(tree))))
    println(c.serialize(c.deserialize(c.serialize(c.deserialize(c.serialize(tree))))))
    println(c.deserialize(c.serialize(null)))
    println(c.serialize(c.deserialize(c.serialize(Node(90)))))
}
