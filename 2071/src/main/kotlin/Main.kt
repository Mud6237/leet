//https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/
class Solution {
	fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
		tasks.sort()
		workers.sort()
		var l = 0
		var h = Math.min(tasks.size, workers.size)
		while(l < h) {
			val m = l + (h - l) / 2
			var p = pills
			val ms = workers.slice(workers.size-m-1 until workers.size).toMutableList()
			//println("l = ${tasks.slice(l until h)}")
			//println("m = $m ms = ${ms}")
			for(i in ms.lastIndex downTo 0) {
				//println("k = $k")
				if(tasks[i] <= ms.last()) {
					//println("does not need pill")
					ms.removeAt(ms.lastIndex)
				} else if (p > 0) {
					//println("needs a pill")
					var k = ms.binarySearch(tasks[i] - strength)
					if (k < 0) {
						k = (-k - 1)
					}
					//println("k after pill = $k")
					if (k < ms.size) {
						ms.removeAt(k)
						p -= 1
					}
				} else {
					break
				}
			}
			if (ms.isEmpty()) {
				l = m+1
			} else {
				h = m
			}
		}
		return l
	}
}