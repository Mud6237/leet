//https://leetcode.com/problemset/all?search=995
// https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/

class Solution {
	fun minKBitFlips(nums: IntArray, k: Int): Int {
		var lastFlipIndex = -k
		val flip = IntArray(nums.size)
		var flipCount = 0
		var flipCountInLastk = 0
		for(i in 0 until nums.size) {
			if (i >= k) {
				if (flip[i-k] == 1) {
					flipCountInLastk -= 1
				}
			}
			val n = if (flipCountInLastk % 2 == 0) nums[i] else nums[i] xor 1
			if (n == 0) {
				flipCount += 1
				flipCountInLastk += 1
				flip[i] = 1
				lastFlipIndex = i
			}
		}
		if (lastFlipIndex + k > nums.size) {
			return -1
		}
		return flipCount
	}
}

fun main() {
	var nums = intArrayOf(0,0,0,1,0,1,1,0)
	var k = 3
	println(Solution().minKBitFlips(nums, k))
	nums = intArrayOf(1, 1, 0)
	k = 2
	println(Solution().minKBitFlips(nums, k))
	nums = intArrayOf(0, 1, 0)
	k = 1
	println(Solution().minKBitFlips(nums, k))
	nums = intArrayOf(1,1,1,1,1,1,1,1)
	println(Solution().minKBitFlips(nums, 4))
}
