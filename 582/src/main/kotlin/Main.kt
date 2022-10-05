//https://leetcode.com/problems/kill-process/
//https://leetcode.com/problemset/all?search=582
class Solution {
	fun killProcess(pid: List<Int>, ppid: List<Int>, kill: Int): List<Int> {
		val g =  hashMapOf<Int, MutableList<Int>>()
		for(i in 0 until ppid.size) {
			val j = pid[i]
			val k = ppid[i]
			val l = g.getOrPut(k, { mutableListOf<Int>() })
			l.add(j)
		}
		val emptyList = mutableListOf<Int>()
		var queue = mutableListOf<Int>(kill)
		val result = mutableListOf<Int>()
		while(queue.isNotEmpty()) {
			val queueSize = queue.size
			val nextQueue = mutableListOf<Int>()
			for(i in 0 until queueSize) {
				val k = queue[i]
				nextQueue.addAll(g.getOrDefault(k, emptyList))
			}
			result.addAll(queue)
			queue = nextQueue
		}
		return result
	}	
}