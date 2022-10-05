//https://leetcode.com/problems/number-of-visible-people-in-a-queue/
class Solution {
	fun canSeePersonsCount(heights: IntArray): IntArray {
		val r = IntArray(heights.size)
		val s = mutableListOf<Int>()
		for(j in heights.lastIndex downTo 0) {
			var c = 0
			while(s.isNotEmpty() && heights[s.last()] <= heights[j]) {
				s.removeAt(s.lastIndex)
				c += 1
			}
			r[j] = c + if (s.size > 0) 1 else 0
			s.add(j)
		}
		return r
	}
}