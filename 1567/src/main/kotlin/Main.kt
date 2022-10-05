//https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
class Solution {
	fun getMaxLen(nums: IntArray): Int {
		var minusCount = 0
		var minusFirstIndex = -1
		var maxLength = 0
		var zeroIndex = -1
		for((index, num) in nums.withIndex()) {
			if (num <= 0) {
				if (num == 0) {
					minusCount = 0
					zeroIndex = index
					minusFirstIndex = index - 1
				} else {
					minusFirstIndex =  if (minusCount == 0) index else minusFirstIndex
					minusCount += 1
				}
			}
			var mIndex = if (minusCount % 2 == 0) -1 else minusFirstIndex
			var zIndex = zeroIndex
			maxLength = Math.max(maxLength, index - Math.max(mIndex, zIndex))
		}
		return maxLength
	}
}