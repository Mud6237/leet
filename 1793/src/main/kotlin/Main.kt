class Solution {
	fun maximumScore(nums: IntArray, k: Int): Int {
		val stack = mutableListOf<Int>()
		var a = 0
		for((j, n) in nums.withIndex()) {
			while(stack.isNotEmpty() && n < nums[stack.last()]) {
				val t = stack.removeAt(stack.lastIndex)
				val i = if(stack.isEmpty()) 0 else stack.last() + 1
				if (i <= k && k < j) {
					a = Math.max(a, nums[t] * (j - i))
				}
			}
			stack.add(j)
		}
		val j = nums.size
		while(stack.isNotEmpty()) {
			val t = stack.removeAt(stack.lastIndex)
			val i = if(stack.isEmpty()) 0 else stack.last() + 1
			if (i <= k && k < j) {
				a = Math.max(a, nums[t] * (j - i))
			}
		}
		return a
	}
}