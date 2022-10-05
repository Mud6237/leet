//https://leetcode.com/problemset/all?search=503
//https://leetcode.com/problems/next-greater-element-ii/
class Solution {
	fun nextGreaterElements(nums: IntArray): IntArray {
		val stack = mutableListOf<Pair<Int, Int>>()
		val result = IntArray(nums.size, { -1 })
		for((j, num) in nums.withIndex()) {
			while(stack.isNotEmpty() && num > stack.last().second) {
				val (i) = stack.removeAt(stack.lastIndex)
				result[i] = num
			}
			stack.add(Pair(j, num))
		}
		var j = 0
		while(j < nums.size && stack.isNotEmpty()) {
			val num = nums[j]
			if (num > stack.last().second) {
				val (i) = stack.removeAt(stack.lastIndex)
				result[i] = num
			} else {
				j += 1
			}
		}
		return result
	}
}
