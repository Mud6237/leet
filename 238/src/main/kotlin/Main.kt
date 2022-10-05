class Solution {
	fun productExceptSelf(nums: IntArray): IntArray {
		var result = IntArray(nums.size, { 1 })
		var p = nums.first()
		for(i in 1 until nums.size) {
			result[i] = p
			p *= nums[i]
		}
		p = nums.last()
		for(i in nums.lastIndex-1 downTo 0) {
			result[i] = result[i] * p
			p = p * nums[i]
		}
		return result
	}
}