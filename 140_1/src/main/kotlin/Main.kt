//https://leetcode.com/problemset/all?search=140
//https://leetcode.com/problems/word-break-ii/
//https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
		//return DFS(s, wordDict, hashMapOf<String, List<String>>())
		return wordBreakImpl(s, wordDict.toSet(), hashMapOf<String, List<String>>())
    }

	private fun DFS(s: String, wordDict: List<String>, m: HashMap<String, List<String>>): List<String> {
		if(m.contains(s)) {
			m.get(s)
		}
		val res = mutableListOf<String>()
		if(s.length == 0) {
			res.add("")
			return res
		}
		for(dictionaryWord in wordDict) {
			if(s.startsWith(dictionaryWord)) {
				val nextList = DFS(s.substring(dictionaryWord.length), wordDict, m)
				println("word = $dictionaryWord next list = $nextList")
				for(nextWord in nextList) {
					val newString = dictionaryWord + if (nextWord.isEmpty()) "" else " " + nextWord
					res.add(newString)
				}
			}
		}
		m[s] = res
		return res
	}

	fun wordBreakImpl(s: String, wordDict: Set<String>, m: HashMap<String, List<String>>): List<String> {
		val res = mutableListOf<String>()
		if (s.length == 0) {
			return res
		}
		val g = m[s]
		if (g != null) {
			return g
		}
		for(i in 1..s.length) {
			val p = s.substring(0, i)
			if(wordDict.contains(p)) {
				val q = s.substring(i)
				if(q.isEmpty()) {
					res.add(p)
				}
				val r = wordBreakImpl(q, wordDict, m)
				for(w in r) {
					res.add(p + " " + w)
				}
			}
		}
		m[s] = res
		return res
	}
}