//https://leetcode.com/problems/h-index/
class Solution {
	fun hIndex(citations: IntArray): Int {
		citations.sort()
		var h = 0
		for(i in 0 until citations.size) {
			val c = citations[i]
			val k = citations.size - i
			h = Math.max(h, Math.min(c, k))
		}
		return h
	}
}