// https://leetcode.com/problemset/all?search=84
// https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
// https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)/191784
class Solution {
	fun largestRectangleArea(heights: IntArray): Int {
		val left = IntArray(heights.size, { -1 })
		val stack = mutableListOf<Int>()
		stack.add(0)
		for(i in 1..heights.lastIndex) {
			while(stack.isNotEmpty() && heights[stack.last()] > heights[i] )  {
				stack.removeLast()
			}
			left[i] = if (stack.isNotEmpty()) stack.last() else -1
			stack.add(i)
		}
		stack.clear()
		val right = IntArray(heights.size, {heights.size})
		stack.add(heights.lastIndex)
		for(i in heights.lastIndex-1 downTo 0) {
			while(stack.isNotEmpty() && heights[stack.last()] > heights[i] ) {
				stack.removeLast()
			}
			right[i] = if (stack.isNotEmpty()) stack.last() else heights.size
			stack.add(i)
		}
		var maxArea = Int.MIN_VALUE
		for(i in 0..heights.lastIndex) {
			maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1) )
		}
		return maxArea
	}
}
fun main(args: Array<String>) {
	val heights = intArrayOf(2,1,5,6,2,3)
	println(Solution().largestRectangleArea(heights))
}
