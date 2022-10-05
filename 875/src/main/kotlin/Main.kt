//https://leetcode.com/problems/koko-eating-bananas/solution/
class Solution {
	fun minEatingSpeed(piles: IntArray, h: Int): Int {
		var r = Int.MIN_VALUE
		for(p in piles) {
			r = Math.max(r, p)
		}
		var l = 1
		while(l != r) {
			val m = l + (r-l) / 2
			var s = 0
			val md = m.toDouble()
			for(p in piles) {
				s += Math.ceil(p / md).toInt()
			}
			if (s > h) {
				l = m+1
			} else {
				r = m
			}
		}
		return r
	}
}