//https://leetcode.com/problemset/all?search=45
//https://leetcode.com/problems/jump-game-ii/
class Solution {
	fun jump(nums: IntArray): Int {
		var index = 0
		var count = 0
		while(index < nums.lastIndex) {
			var x = nums[index]
			var y = Math.min(x + index, nums.lastIndex)
			var j = index + 1
			var nextIndex = j
			while(j <= y) {
				if (j + nums[j] > nextIndex + nums[nextIndex]) {
					nextIndex = j
				}
				j += 1
			}
			//println("nextIndex = ${nextIndex} ${nums[nextIndex]}")
			if (y < nums.lastIndex) {
				index = nextIndex
			} else {
				index = y
			}
			count += 1
		}
		return count
	}
}

fun main() {
	//println(Solution().jump(intArrayOf(2,3,1,1,4)))
	//println(Solution().jump(intArrayOf(2,3,0,1,4)))
	//println(Solution().jump(intArrayOf(10,9,0,0,0,0,0,0,0,0,0)))
	//println(Solution().jump(intArrayOf(3,9)))
	//println(Solution().jump(intArrayOf(3)))
	//println(Solution().jump(intArrayOf(1,2,3)))
	println(Solution().jump(intArrayOf(1,2,1,1,1)))
}
