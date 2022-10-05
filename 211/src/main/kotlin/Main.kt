//https://leetcode.com/problemset/all?search=211
//https://leetcode.com/problems/design-add-and-search-words-data-structure/
class WordDictionary() {
	companion object {
		fun toIndex(c: Char): Int = c - 'a'
		fun nodeForChar(list: MutableList<Node?>, i: Int): Node {
			var n: Node? = list[i]
			if (n != null) {
				return n
			}
			var newNode = Node()
			list[i] = newNode
			return newNode
		}
	}
	data class Node(
		var leaf: Boolean = false,
		var next: MutableList<Node?>? = null,
	)

	private var root = Node()

	fun addWord(word: String) {
		var node = root
		for(c in word) {
			val nextList = node.next ?: MutableList<Node?>(26, { null })
			var nextNode = nodeForChar(nextList, toIndex(c))
			node.next = nextList
			node = nextNode
		}
		node.leaf = true
	}
	
	fun search(word: String): Boolean {
		var i = 0
		var currentNodes = mutableListOf(root)
		var emtpyList = mutableListOf<Node?>()
		while(currentNodes.isNotEmpty() && i < word.length) {
			var nextChar = word[i]
			var nextNodes = mutableListOf<Node>()
			if (nextChar == '.') {
				for(currentNode in currentNodes) {
					val next = currentNode.next ?: emtpyList
					nextNodes.addAll(next.filterNotNull())
				}
			} else {
				for(currentNode in currentNodes) {
					var next = currentNode.next?.get(toIndex(nextChar)) ?: continue
					nextNodes.add(next)
				}
			}
			currentNodes = nextNodes
			i += 1
		}
		return currentNodes.filterNotNull().any({ it.leaf })
	}
}
