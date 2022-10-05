// https://leetcode.com/problems/word-break-ii/

class Solution {
	
	fun wordBreak(s: String, wordDict: List<String>): List<String> {
		val words = wordDict.associateBy({it}, {true})
		val queue = ArrayDeque<List<String>>()
		queue.add(mutableListOf(s))
		val result = mutableListOf<String>()
		while(queue.isNotEmpty()) {
			val front = queue.removeFirst()
			val lastStr = front.last()
			for(i in 1..lastStr.lastIndex) {
				val lastStrSubStr = lastStr.substring(0, i)
				val substringExists = words.getOrDefault(lastStrSubStr, false)
				if (substringExists) {
					val frontClone = front.toMutableList()
					frontClone.add(lastStrSubStr)
					frontClone.add(lastStr.substring(i, lastStr.length))
					queue.addLast(frontClone)
				}
			}
			if (words.getOrDefault(lastStr, false)) {
				val frontClone = front.toMutableList()
				frontClone.add(lastStr)
				result.add(frontClone.filterIndexed{index, v -> index % 2 != 0}.joinToString(" "))
			}
		}
		return result
	}
}
fun main(args: Array<String>) {
	var s = "catsanddog"
	var wordDict = listOf("cat","cats","and","sand","dog")
	val expected =  listOf("cats and dog","cat sand dog")
	var actual = Solution().wordBreak(s, wordDict)
	actual.toMutableList().sort()
	println(actual)

	s = "pineapplepenapple"
	wordDict = listOf("apple","pen","applepen","pine","pineapple")
  actual = Solution().wordBreak(s, wordDict) 
	actual.toMutableList().sort()
	println(actual)
}
