// https://leetcode.com/problemset/all?search=645
class Solution {
	fun findErrorNums(nums: IntArray): IntArray {
		val n = nums.size
		val y = n * (n + 1) / 2
		val b = BooleanArray(n)
		var s = 0
		var x = 0
		for(i in 0 until n) {
			if(b[nums[i]-1]) {
				x = nums[i]
			}
			b[nums[i]-1] = true
			s += nums[i]
		}
		return intArrayOf(x, Math.abs(y - (s - x)))
	}
}
