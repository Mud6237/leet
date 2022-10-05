
// https://leetcode.com/problems/single-element-in-a-sorted-array/


// hint: Find first even index not followed by its pairs
class Solution {
	fun singleNonDuplicate(nums: IntArray): Int {
		var l = 0
		var h = nums.lastIndex
		while(h > l) {
			var m = l + (h - l) / 2
			if (m % 2 != 0) {
				m -= 1
			}
			if (nums[m] == nums[m+1]) {
				l += 2
			} else {
				h = m	
			}
		}
		return nums[l]
	}
}
