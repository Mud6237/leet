//https://leetcode.com/problems/stream-of-characters/

class StreamChecker(words: Array<String>) {

	class TrieNode(
		val isLeaf: Boolean = false,
		val nodes: Array<TrieNode?> = Array(26, { null })
	)
	private val root = TrieNode()
	private var maxWordLength: Int = 0
	private val cArray: CharArray
	private var cIndex = 0
	init {
		for(word in words) {
			addReverseWord(root, word)
			maxWordLength = Math.max(maxWordLength, word.length)
		}
		cArray = CharArray(maxWordLength)
	}
	
	fun addReverseWord(t: TrieNode, s: String) {
		var n = t
		for(i in s.length - 1 downTo 0) {
			val c = s[i]
			val ci = c - 'a'
			var k = n.nodes[ci] ?: TrieNode(i == 0)
			n.nodes[ci] = k
			n = k
		}
	}


	fun containsReverse(a: CharArray, s: Int): Boolean {
		var n = root
		val c = Math.min(s, a.size)
		var j = 0
		var i = s
		while(j < c) {
			val ci = a[i % a.size] - 'a'
			n = n.nodes[ci] ?: return false
			if (n.isLeaf) {
				return true
			}
			i -= 1
			j += 1
		}
		return false
	}
	
	
	fun query(letter: Char): Boolean {
		cArray[cIndex%maxWordLength] = letter
		val res = containsReverse(cArray, cIndex)
		cIndex = cIndex + 1
		return res
	}
}

fun main() {
	val words = arrayOf("ab","ba","aaab","abab","baa")
	val streamChecker = StreamChecker(words)
	println(streamChecker.query('a'))
	println(streamChecker.query('a'))
	println(streamChecker.query('a'))
	println(streamChecker.query('a'))
	println(streamChecker.query('a'))
	println(streamChecker.query('b'))
	println(streamChecker.query('a'))
}
