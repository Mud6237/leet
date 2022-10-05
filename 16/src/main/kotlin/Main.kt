//https://leetcode.com/problemset/all?search=16
//https://leetcode.com/problems/3sum-closest/
class Solution {
	fun threeSumClosest(nums: IntArray, target: Int): Int {
		var d = Int.MAX_VALUE
		var r = 0
		nums.sort()
		//println(nums.toList())
		for(i in 0 until nums.size - 2) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue
			}
			var j = i + 1
			var k = nums.lastIndex
			//println("For num = ${nums[i]}")
			while(k > j) {
				if(j > i + 1 && nums[j] ==  nums[j-1]) {
					j += 1
					continue
				}
				if (k < nums.lastIndex && nums[k] == nums[k+1]) {
					k -= 1
					continue
				}
				val s = nums[i] + nums[j] + nums[k]
				val diff = target - s
				val absDiff = Math.abs(diff)
				//println("num[j] = ${nums[j]} nums[k] = ${nums[k]} s = ${s} diff = $diff")
				if(absDiff < d) {
					r = s
					d = absDiff
				}
				if (diff == 0) {
					return s
				} else if (diff > 0) {
					j += 1
				} else {
					k -= 1
				}
			}
		}
		return r
	}
}