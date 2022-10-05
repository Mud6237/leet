// https://leetcode.com/problemset/all?search=315
// https://leetcode.com/problems/count-of-smaller-numbers-after-self/

class Solution {
	fun countSmaller(nums: IntArray): List<Int> {
		val count = MutableList<Int>(nums.size, { 0 })
		val stack = mutableListOf<Int>()
		stack.add(nums.lastIndex)
		for(i in nums.lastIndex - 1 downTo 0) {
			while(stack.isNotEmpty() && nums[stack.last()] >= nums[i]) {
				stack.removeLast()
			}
			count[i] = stack.size
			stack.add(i)
		}
		return count
	}
}
fun main(args: Array<String>) {
	val c = Solution().countSmaller(intArrayOf(5,2,6,1))
	println(c)
}
