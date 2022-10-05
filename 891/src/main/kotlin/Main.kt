//https://leetcode.com/problems/sum-of-subsequence-widths/
//https://leetcode.com/problems/sum-of-subsequence-widths/discuss/161267/JavaC%2B%2BPython-Sort-and-One-Pass
class Solution {
	fun sumSubseqWidths(nums: IntArray): Int {
		nums.sort()
		val modN = 1_000_000_007L
		var totalSum = 0L
		var c = 1L
		val n = nums.lastIndex
		for(i in 0 until nums.size) {
			val x = (nums[i] * c) % modN
			val y = (nums[n-i] * c) % modN
			totalSum = (totalSum + x - y) % modN
			c = (c * 2) % modN
		}
		val k = (totalSum + modN) % modN
		return k.toInt()
	}
}