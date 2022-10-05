//https://leetcode.com/problemset/all?search=15
//https://leetcode.com/problems/3sum/
class Solution {
	fun threeSum(nums: IntArray): List<List<Int>> {
		if (nums.size < 3) {
			return emptyList()
		}
		val result = mutableListOf<List<Int>>()
		nums.sort()
		for(i in 0 until nums.size) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue
			}
			var j = i + 1
			var k = nums.lastIndex
			while(k > j) {
				if(j > i + 1 && nums[j-1] == nums[j]) {
					j += 1
					continue
				}
				if(k < nums.lastIndex && nums[k+1] == nums[k]) {
					k -= 1
					continue
				}
				val z = nums[i] + nums[j] + nums[k]
				if (z > 0) {
					k -= 1
				} else if (z < 0) {
					j += 1
				} else {
					result.add(listOf(nums[i], nums[j], nums[k]))
					j += 1
					k -= 1
				}
			}
		}
		return result
	}
}
