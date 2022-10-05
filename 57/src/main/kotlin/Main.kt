//https://leetcode.com/problemset/all?search=57
//https://leetcode.com/problems/insert-interval/
class Solution {
	private fun lowerBound(
		intervals: Array<IntArray>,
		index: Int,
		target: Int,
	  fromIndex: Int = 0,
		toIndex: Int = intervals.lastIndex
	): Int {
		var i = fromIndex
		var j = toIndex
		while(j >= i) {
			val m = i + (j - i)/2
			val e = intervals[m][index]
			if (e >= target) {
				j = m-1
			} else {
				return m
			}
		}
		return Math.max(j, fromIndex-1)
	}

	private fun upperBound(
		intervals: Array<IntArray>,
		index: Int,
		target: Int,
	  fromIndex: Int = 0,
		toIndex: Int = intervals.lastIndex
	): Int {
		var i = fromIndex
		var j = toIndex
		while(j >= i) {
			val m = i + (j - i)/2
			val e = intervals[m][index]
			if (e < target) {
				i = m+1
			} else {
				return m
			}
		}
		return Math.min(i, toIndex + 1)
	}

	fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
		if (intervals.size < 1) {
			return arrayOf(newInterval)
		}
		val c = compareBy<IntArray>({ it.first() })
		var xi = intervals.binarySearch(newInterval, c)
		if (xi < 0) {
			xi = (-xi - 1) - 1
		}
		var xj = upperBound(intervals, 1, newInterval[0], 0, xi)
		var yj = intervals.binarySearch(intArrayOf(newInterval[1], newInterval[1]), c)
		if (yj < 0) {
			yj = (-yj - 1) - 1
		}
		var x = newInterval[0]
		if (xj < intervals.size) {
			x = Math.min(x, intervals[xj][0])
		}
		var y = newInterval[1]
		if (yj >= 0) {
			y = Math.max(y, intervals[yj][1])
		}
		var m = intArrayOf(x, y)
		var s = xj + 1 + (intervals.lastIndex - yj)
		//println("xi = $xi xj = $xj new size = $s, yj = $yj m = ${m.toList()}")
		val newIntervals = Array(s, { intArrayOf(0, 0)})
		for(i in 0 until xj) {
			newIntervals[i] = intervals[i]
		}
		newIntervals[xj] = m
		var j = xj + 1
		for(i in yj+1 until intervals.size) {
			newIntervals[j] = intervals[i]
			j = j +1 
		}
		return newIntervals
	}
}