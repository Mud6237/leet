//https://leetcode.com/problemset/all?search=56
//https://leetcode.com/problems/merge-intervals/
class Solution {
	fun merge(intervals: Array<IntArray>): Array<IntArray> {
		val comparator = compareBy<IntArray>({it.first()}).thenBy({ it.last() })
		intervals.sortWith(comparator)
		val result = mutableListOf<IntArray>()
		var prev = intArrayOf(-1, -1)
		for(interval in intervals) {
			if(interval.first() > prev.last()) {
				result.add(interval)
			} else {
				result[result.lastIndex] = intArrayOf(prev.first(), Math.max( prev.last(), interval.last() ) )
			}
			prev = result.last()
		}
		return result.toTypedArray()
	}
}