//https://leetcode.com/problemset/all/?search=1268
//https://leetcode.com/problems/search-suggestions-system/

class Solution {
	class TrieNode(
		var children: MutableList<TrieNode?>? = null,
		var words: MutableList<Int>? = null
	)

	private fun insertWord(word: String, index: Int, root: TrieNode) {
		var node: TrieNode = root
		//println("Adding word = ${word}")
		for(c in word) {
			val children = node.children ?: MutableList<TrieNode?>(26, { null })
			val nextNode = children[c - 'a'] ?: TrieNode()
			val wordsList = nextNode.words ?: mutableListOf<Int>()
			if (wordsList.size < 3) {
				wordsList.add(index)
			}
			//println("C = $c WordList = ${wordsList}")
			nextNode.words = wordsList
			children[c-'a'] = nextNode
			node.children = children
			node = nextNode
		}
	}

	private fun search(s: String, root: TrieNode): List<List<Int>> {
		val result = mutableListOf<List<Int>>()
		var node = root
		for(c in s) {
			var children = node.children ?: break
			val nextNode = children[c - 'a'] ?: break
			val wordsList = nextNode.words ?: break
			result.add(wordsList)
			node = nextNode
		}
		return result
	}

	fun suggestedProducts_Trie(products: Array<String>, searchWord: String): List<List<String>> {
		var root = TrieNode(MutableList<TrieNode?>(26, { null }))
		products.sort()
		for((index, product) in products.withIndex()) {
			insertWord(product, index, root)
		}
		val searchIndexes = search(searchWord, root)
		val result = mutableListOf<List<String>>()
		for(searchResult in searchIndexes) {
			val resultList = mutableListOf<String>()
			for(index in searchResult) {
				resultList.add(products[index])	
			}
			result.add(resultList)
		}
		for(i in 0 until searchWord.length - searchIndexes.size) {
			result.add(emptyList<String>())
		}
		return result
	}

	fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
		val result = mutableListOf<List<String>>()
		products.sort()
		val sentinel = '~'
		for(i in 0 until searchWord.length) {
			val sa = searchWord.substring(0, i + 1)
			var saIndex = products.binarySearch(sa)
			if (saIndex < 0) {
				saIndex = -(saIndex + 1)
			}
			val sb = sa + sentinel
			var sbIndex = products.binarySearch(sb)
			sbIndex = -(sbIndex + 1)
			val count = Math.min(sbIndex - saIndex, 3)
			if (count < 1) {
				break
			}
			var r = mutableListOf<String>()
			for(j in saIndex until saIndex+count) {
				r.add(products[j])
			}
			result.add(r)
		}
		val k = searchWord.length - result.size
		for(i in 0 until k) {
			result.add(emptyList())
		}
		return result
	}
}
