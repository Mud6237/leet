//https://leetcode.com/problems/course-schedule-ii/

class Solution {

	fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
		var resultIndex = 0
		var result = IntArray(numCourses)
		var stack = mutableListOf<Pair<Int, Int>>()
		var h = hashMapOf<Int, MutableList<Int>>()
		for(p in prerequisites) {
			val l = h.getOrPut(p.first(), { mutableListOf<Int>() })
			l.add(p.last())
		}
		var marked = IntArray(numCourses)
		//println(h)
		val emptyList = mutableListOf<Int>()
		for(i in 0 until numCourses) {
			if (marked[i] == 0) {
				stack.add(i to 0)
			}
			while(stack.isNotEmpty()) {
				outer@while(true) {
					val t = stack.last()
					marked[t.first] = 1
					val edges = h.getOrDefault(t.first, emptyList)
					for(k in t.second until edges.size) {
						val v = edges[k]
						if (marked[v] == 0) {
							stack[stack.lastIndex] = t.first to k
							stack.add(v to 0)
							continue@outer
						}
						if (marked[v] == 1) {
							return intArrayOf()
						}
					}
					break
				}
				//println("stack = $stack")
				val (t) = stack.removeAt(stack.lastIndex)
				marked[t] = 2
				result[resultIndex] = t
				resultIndex += 1
			}
		}
		return result
	}
}