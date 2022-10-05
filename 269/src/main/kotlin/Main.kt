// https://leetcode.com/problems/alien-dictionary/

class Solution {
	companion object {
		fun toIndex(c: Char): Int {
			return c - 'a'
		}
		fun indexToAscii(i: Int): Char {
			return Char(97 + i)
		}
	}

	enum class NodeColor {
		WHITE,
		GREY,
		BLACK
	}

	private fun makeAdjacenyList(words: Array<String>): Array<out List<Char>> {
		val adjList = Array(26, { mutableListOf<Char>() })
		for(i in 1..words.lastIndex) {
			val l = Math.min(words[i].lastIndex, words[i-1].lastIndex)
			var j: Int = 0
			while(j <= l && words[i][j] == words[i-1][j]){
				j+=1
			}
			if (j <= l) {
				val u = words[i][j]
				val v = words[i-1][j]
				adjList[toIndex(u)].add(v)
			}
		}
		return adjList
	}

	private fun dfs(i: Int, adjList: Array<out List<Char>>, visited: Array<NodeColor>, result: StringBuilder): Boolean {
		visited[i] = NodeColor.GREY
		//println("doing dfs for ${indexToAscii(i)}")
		for(v in adjList[i]) {
			val nodeIndex = toIndex(v)
			val nodeColor = visited[nodeIndex]
			if (nodeColor == NodeColor.GREY ) {
				return false
			}
			if (nodeColor == NodeColor.WHITE && !dfs(nodeIndex, adjList, visited, result)) {
				return false
			}
		}
		visited[i] = NodeColor.BLACK
		//println("appending ${indexToAscii(i)}")
		result.append(indexToAscii(i))
		return true
	}

	fun alienOrder(words: Array<String>): String {
		val adjList = makeAdjacenyList(words)
		val visited = Array<NodeColor>(26, { NodeColor.WHITE })
		val result = StringBuilder()
		for(i in 0 until 26) {
			if (adjList[i].isNotEmpty() && visited[i] == NodeColor.WHITE && !dfs(i, adjList,visited, result)) {
				return ""
			}
		}
		return result.toString()
	}
}

fun main(args: Array<String>) {
	val words = arrayOf("wrt","wrf","er","ett","rftt")
	val expected = "wertf"
	val actual = Solution().alienOrder(words)
	println(actual)
}
