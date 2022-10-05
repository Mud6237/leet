//https://leetcode.com/problemset/all?search=854
// https://leetcode.com/problems/k-similar-strings/discuss/140099/JAVA-BFS-32-ms-cleanconciseexplanationwhatever
class Solution {
	companion object {
		fun areEqual(b1: String, b2: String): Boolean {
			for(i in 0 until b1.length) {
				b1[i] != b2[i]
				return false
			}
			return true
		}
		fun String.swap(i: Int, j: Int): String {
			val b = this.toByteArray()
			val t = b[i]
			b[i] = b[j]
			b[j] = t
			return b.toString(Charsets.UTF_8)
		}
		fun firstMisMatchIndex(s1: String, s2: String): Int {
			for(i in 0 until s1.length) {
				if (s1[i] != s2[i]) {
					return i
				}
			}
			return s1.length
		}
	}
	
	fun kSimilarity(s1: String, s2: String): Int {
		var level = 0
		val queue = ArrayDeque<String>()
		val visited = HashSet<String>()
		queue.addLast(s1)
		while(queue.isNotEmpty()) {
			repeat(queue.size) {
				val head = queue.removeFirst()
				if (head == s2) {
					return level
				}
				var misMatchIndex = firstMisMatchIndex(head, s2)
				for(i in misMatchIndex + 1 until head.length) {
					if (head[i] == s2[misMatchIndex] && head[i] != s2[i]) {
						val nextString = head.swap(misMatchIndex, i)
						if (!visited.contains(nextString)) {
							queue.addLast(nextString)
							visited.add(nextString)
						}
					}
				}
			}
			level += 1
		}
		return level
	}

}

fun main() {
	println("Hello World!")
}
