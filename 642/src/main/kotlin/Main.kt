// https://leetcode.com/problems/design-search-autocomplete-system/

// https://leetcode.com/problems/design-search-autocomplete-system/discuss/105376/Java-solution-Trie-and-PriorityQueue

import java.util.PriorityQueue

class AutocompleteSystem(sentences: Array<String>, times: IntArray) {
	class TrieNode(
		val d: HashMap<Char, TrieNode> = hashMapOf(),
		val s: HashMap<String, Int> = hashMapOf()
	)
	class Trie(private val root: TrieNode = TrieNode()){
		fun add(s: String, t: Int) {			
			var node = root
			for(c in s) {
				val nextNode = node.d.getOrPut(c, { TrieNode() })
				nextNode.s[s] = node.s.getOrDefault(s, 0) + t
				node = nextNode
			}
		}
		fun stringsForPrefix(s: String, count: Int = 3): List<String> {
			var node = root 
			for(c in s) {
				node = node.d[c] ?: return emptyList()
			}
			val pq = PriorityQueue<Map.Entry<String, Int>>() { e1, e2 ->
				if (e2.value == e1.value) e1.key.compareTo(e2.key) else e2.value - e1.value
    	}
			pq.addAll(node.s.entries)
			val resultList = mutableListOf<String>()		
			var n = Math.min(count, pq.size)
			while(n > 0) {
				resultList.add(pq.poll().key)
				n -= 1
			}
			return resultList
		}
	}

	private val trie = Trie()
	private var sb =  StringBuilder()

	init {
		sentences.forEachIndexed { index, sentence -> 
			trie.add(sentence, times[index])
		}
	}

	fun input(c: Char): List<String> {
		if (c == '#') {
			trie.add(sb.toString(), 1)
			sb.clear()
			return emptyList()
		}
		sb.append(c)
		return trie.stringsForPrefix(sb.toString())
	}
}


fun main(args: Array<String>) {
	val sentences = arrayOf("i love you", "island", "iroman", "i love leetcode")
	val times = intArrayOf(5, 3, 2, 2)
	val autocompleteSystem = AutocompleteSystem(sentences, times)
	var actual = autocompleteSystem.input('i')
	println(actual)
	actual = autocompleteSystem.input('s')
	println(actual)
	actual = autocompleteSystem.input('l')
	println(actual)
	actual = autocompleteSystem.input('a')
	println(actual)
	actual = autocompleteSystem.input('n')
	println(actual)
	actual = autocompleteSystem.input('d')
	println(actual)
}
