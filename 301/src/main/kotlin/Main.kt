// https://leetcode.com/problemset/all?search=301
// https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
class Solution {
	companion object {
		fun isValid(s: String): Boolean {
			//()())( valid = true
			var count = 0
			for(c in s) {
				if (c == '(') { 
					count += 1
				}
				if (c == ')' ) {
					count -= 1
				}
				if (count < 0) {
					return false
				}
			}
			return count == 0
		}
	}

	fun removeInvalidParentheses(s: String): List<String> {
		val result = mutableListOf<String>()
		var queue = ArrayDeque<String>()
		var visited = hashSetOf<String>()
		queue.add(s)
		visited.add(s)
		while(queue.isNotEmpty() && result.isEmpty()) {
			var levelSize = queue.size
			for (_i in 0 until levelSize) {
				val head = queue.removeFirst()
				if (isValid(head)) {
					result.add(head)
					continue
				}
				for((j, c) in head.withIndex()) {
					if (c == '(' || c == ')') {
						val nextCandidate = head.substring(0, j) + head.substring(j + 1, head.length)
						if (!visited.contains(nextCandidate)) {
							queue.addLast(nextCandidate)
							visited.add(nextCandidate)
						}
					}
				}
			}
		}
		return result
	}
}
fun main() {
	println(Solution().removeInvalidParentheses("()())()))
	println(Solution().removeInvalidParentheses(")("))
}
