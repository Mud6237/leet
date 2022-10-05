class Solution {
	fun threeSum(nums: IntArray, target: Int, startIndex: Int): MutableList<List<Int>> {
		val result = mutableListOf<List<Int>>()
		for(k in startIndex..nums.lastIndex - 2) {
			if (k > startIndex && nums[k-1] == nums[k]) {
				continue
			}
			var x = k + 1
			var y = nums.lastIndex
			while(y > x) {
				if(y < nums.lastIndex && nums[y] == nums[y + 1]) {
					y -= 1
					continue
				}
				val s = nums[x] + nums[y] + nums[k]
				if (s > target) {
					y -= 1
				} else if ( s < target ) {
					x += 1
				} else {
					result.add(listOf(nums[k], nums[x], nums[y]))
					x += 1
					y -= 1
				}
			}
		}
		return result
	}

	fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
		nums.sort()
		var result = mutableListOf<List<Int>>()
		var prev = Int.MIN_VALUE
		//println(nums.toList())
		for(i in 0..nums.lastIndex - 3) {
			if (nums[i] == prev) {
				continue
			}
			//println("target = ${target - nums[i]}")
			threeSum(nums, target - nums[i], i+1).forEach {
				//println(it)
				result.add(listOf(nums[i]) + it)
			}
			prev = nums[i]
		}
		return result
	}
}