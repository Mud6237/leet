//https://leetcode.com/problemset/all?search=31
class Solution {
	fun nextPermutation(nums: IntArray): Unit {
		for(i in nums.lastIndex-1 downTo 0) {
			if(nums[i] < nums[i+1]) {
				var k = i+1
				for(j in k+1 until nums.size) {
					if(nums[j] > nums[i] && nums[j] < nums[k]) {
						k = j
					}
				}
				val t = nums[i]
				nums[i] = nums[k]
				nums[k] = t
				nums.sort(i+1, nums.size)
				return
			}
		}
		nums.reverse()
	}
}