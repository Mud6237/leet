//https://leetcode.com/problems/patching-array/
class Solution {
	fun minPatches(nums: IntArray, n: Int): Int {
		var cover = 0L
		var patch = 0
		var index = 0
		while(cover < n) {
			val next = cover + 1
			if (index < nums.size && nums[index] <= next) {
				cover += nums[index]
				index += 1
			} else {
				cover += next
				patch += 1
			}
		}
		return patch
	}
}