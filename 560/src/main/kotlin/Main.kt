class Solution {
	fun subarraySum(nums: IntArray, k: Int): Int {
		var h = hashMapOf<Int,Int>()
		var s = 0
		h[0] = 1
		var c = 0
		for(n in nums) {
			s += n
			c += h.getOrDefault(s-k, 0)
			h[s] = h.getOrDefault(s, 0) + 1
		}
		return c
	}
}