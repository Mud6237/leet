//https://leetcode.com/problemset/all?search=207
//https://leetcode.com/problems/course-schedule/
class Solution {
	fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
		var stack = mutableListOf<Pair<Int, Int>>()
		var g = hashMapOf<Int, MutableList<Int>>()
		for((u, v) in prerequisites) {
			val l = g.getOrPut(u, { mutableListOf<Int>() })
			l.add(v)
		}
		var marked = IntArray(numCourses)
		var emptyList = mutableListOf<Int>()
		for(i in 0 until numCourses) {
			if(marked[i] == 0) {
				stack.add(Pair(i, 0))
			}
			while(stack.isNotEmpty()) {
				outer@while(true) {
					var top = stack.last()
					marked[top.first] = 1
					var edges = g.getOrDefault(top.first, emptyList)
					for(j in top.second until edges.size) {
						val v = edges[j]
						if(marked[v] == 0) {
							stack[stack.lastIndex] = top.first to j+1
							stack.add(v to 0)
							continue@outer
						}
						if(marked[v] == 1) {
							return false
						}
					}
					break
				}
				var top = stack.removeAt(stack.lastIndex)
				marked[top.first] = 2
			}
		}
		return true
	}
}