//https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {

	private fun swap(nums: IntArray, i: Int, j: Int) {
		val t = nums[i]
		nums[i] = nums[j]
		nums[j] = t
	}

	private fun partition(nums: IntArray, x: Int, y: Int): Int {
		if (y <= x) {
			return x
		}
		var j = x
		var i = x + 1
		var k = y
		while(i <= k) {
			if (nums[i] <= nums[j]) {
				swap(nums, i, j)
				j = i
			} else {
				swap(nums, i, k)
				k -= 1
				i -= 1
			} 
			i += 1
		}
		return j
	}

	fun findKthLargest(nums: IntArray, k: Int): Int {
		var y = nums.lastIndex - (k - 1)
		var i = 0
		var j = nums.lastIndex
		while(j >= i) {
			val p = partition(nums, i, j)
			//println("p = $p, nums = ${nums.toList()}")
			if (p == y) {
				return nums[p]
			}
			if (y < p) {
				j = p - 1
			} else {
				i = p + 1
			}
		}
		return -1
	}
}