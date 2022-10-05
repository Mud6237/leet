// https://leetcode.com/problemset/all?search=239
// https://leetcode.com/problems/sliding-window-maximum/
// https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
class Solution {
	fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
		if (nums.size < k) {
			return intArrayOf()
		}
		val result = IntArray(nums.size - k + 1 ) 
		var j = 0
		val deque = ArrayDeque<Int>()
		for(i in 0 until nums.size) {
			if (deque.isNotEmpty() && deque.first() < i-k + 1 ) {
				deque.removeFirst()
			}
			while (deque.isNotEmpty() && nums[i] > nums[deque.last()]) {
				deque.removeLast()
			}
			deque.addLast(i)
			if (i >= k-1) {
				result[j] = nums[deque.first()]
				j += 1
			}
		}
		return result
	}
}

fun main(args: Array<String>) {
	val nums = intArrayOf(1,3,-1,-3,5,3,6,7)
	val k = 3
	val expected = intArrayOf(3,3,5,5,6,7).toList()
	val actual = Solution().maxSlidingWindow(nums, k)
	println(actual.toList())
}
