//http://leetcode.com/problemset/all?search=1235
//https://leetcode.com/problems/maximum-profit-in-job-scheduling/
class Solution {
	fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
		val k = MutableList<Triple<Int, Int, Int>>(startTime.size, { Triple(startTime[it], endTime[it], profit[it] ) })
		k.sortWith(compareBy<Triple<Int, Int, Int>>({ it.second }))
		val d = IntArray(k.size)
		var m = 0
		for(i in 0 until k.size) {
			val t = k[i]
			val s = t.first
			val p = t.third
			d[i] = p
			var rank = k.binarySearchBy(s, 0, i, { it.second })
			if (rank < 0) {
				rank = (-rank - 1) - 1
			} else {
				val r = k[rank].second
				var j = rank + 1
				while(j < i && k[j].second == r) {
					j+=1
					rank += 1
				}
			}
			if (i > 0) {
				var r = 0
				if (rank >= 0) {
					r = d[rank]
				}
				d[i] = Math.max(r+p, d[i-1])
			}
			m = Math.max(m, d[i])
		}
		return m
	}
}