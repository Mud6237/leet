// https://leetcode.com/problemset/all?search=126
// https://leetcode.com/problems/word-ladder-ii/discuss/40434/C%2B%2B-solution-using-standard-BFS-method-no-DFS-or-backtracking

class Solution {
	fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
		var level = 0
		val visited = Array<Int>(wordList.size, { if(wordList[it] == beginWord) level else Int.MAX_VALUE })
		// println("visited: ${visited.toList()}")
		val result = mutableListOf<MutableList<String>>()
		val queue = ArrayDeque<MutableList<String>>()
		queue.add(mutableListOf(beginWord))
		var found = false
		while(queue.isNotEmpty()) {
			level += 1
			// println("queue: ${queue} will repeat ${queue.size} level: ${level}")
			repeat(queue.size) {
				val path = queue.removeFirst()
				val lastNodeByteArray = path.last().toByteArray()
				// println("lastNode ${path.last()}")
				// println("visited: ${visited.toList()}")
				for(i in 0..lastNodeByteArray.lastIndex) {
					val lastChar = lastNodeByteArray[i]
					for(c in 'a'..'z') {
						lastNodeByteArray[i] = c.toByte()
						val lastNodeString = lastNodeByteArray.toString(Charsets.UTF_8)
						val idx = wordList.indexOf(lastNodeString)
						if (idx >= 0) {
							if (lastNodeString == endWord) {
								path.add(endWord)
								result.add(path)
								found = true
							} else if (visited[idx] >= level) {
								// println("found edge to: ${lastNodeString} visited value ${visited[idx]}")
								val pathCopy = path.toMutableList()
								pathCopy.add(lastNodeString)
								queue.addLast(pathCopy)
								visited[idx] = level
							}
						}
					}
					lastNodeByteArray[i] = lastChar
				}
			}
			if (found) {
				break
			}
		}
		return result
	}
}

fun main(args: Array<String>) {
	var beginWord = "hit"
	var endWord = "cog"
	var wordList = listOf("hot","dot","dog","lot","log","cog")
	var expected =  listOf(listOf("hit","hot","dot","dog","cog"),listOf("hit","hot","lot","log","cog"))
	println(Solution().findLadders(beginWord, endWord, wordList)) 

	beginWord = "hit"
	endWord = "cog"
	wordList = listOf("hot","dot","dog","lot","log")
	expected = emptyList<List<String>>()
	println(Solution().findLadders(beginWord, endWord, wordList))  

	beginWord = "red"
	endWord = "tax"
	wordList = listOf("ted","tex","red","tax","tad","den","rex","pee")
	expected = listOf(listOf("red","ted","tad","tax"),listOf("red","ted","tex","tax"),listOf("red","rex","tex","tax"))
	println(Solution().findLadders(beginWord, endWord, wordList))
}
