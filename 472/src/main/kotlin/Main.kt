// https://leetcode.com/problems/concatenated-words/

class Solution {

	class Trie(val root: TrieNode = TrieNode()) {
		companion object {
			fun initialize(): Array<TrieNode?> {
				return Array(26, { null })
			}
			fun indexToChar(i : Int): Char {
				return Char(i + 97)
			}
			fun charToIndex(c: Char): Int {
				return c - 'a'
			}
		}
		class TrieNode(val a: Array<TrieNode?> = initialize(), var leaf:Boolean = false)

		fun insert(s: String): Trie {
			var n = root
			for(c in s) {
				val i = charToIndex(c)
				var node = n.a[i]
				if (node == null) {
					node = TrieNode()
					n.a[i] = node
				}
				n = node
			}
			if (n != root) {
				n.leaf = true
			}
			return this
		}

		private fun nextNode(node: TrieNode, i: Int, s: String) : TrieNode? {
			if (i >= s.length) {
				return null
			}
			val c = s[i]
			return node.a[charToIndex(c)]
		}

		fun countLeavesForString(s: String): Int {
			var leavesCount = 0
			var n = root
			var i = 0
			while(i <= s.lastIndex) {
				val node = nextNode(n, i, s) ?: return 0
				if (node.leaf) {
					val nextIsLeaf = nextNode(node, i+1, s)?.leaf ?: false
					if (nextIsLeaf)  {
						n = node
					} else {
						leavesCount += 1
						n = root
					} 
				} else {
					n = node
				}
				i += 1
			}
			return leavesCount
		}
	}

	fun findAllConcatenatdWordsInDict(words: Array<String>): List<String> {
		val trie = Trie()
		for(word in words) {
			trie.insert(word)
		}
		val result = mutableListOf<String>()
		for(word in words) {
			if (trie.countLeavesForString(word) > 1) { 
				result.add(word)
			}
		}
		return result
	}
}

fun main(args: Array<String>) {
	val t = Solution.Trie().insert("cat").insert("rat")
	println(t.countLeavesForString("catrat"))

	val words = arrayOf("cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat")
	val expected = listOf("catsdogcats","dogcatsdog","ratcatdogcat")
	println(Solution().findAllConcatenatdWordsInDict(words))
 }
