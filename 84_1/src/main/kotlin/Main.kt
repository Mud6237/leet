//https://leetcode.com/problemset/all?search=84
class Solution {
	fun largestRectangleArea(heights: IntArray): Int {
		val stack = mutableListOf<Int>()
		var a = 0
		for((i, h) in heights.withIndex()) {
			while(stack.isNotEmpty() && h < heights[stack.last()]) {
				val k = stack.removeAt(stack.lastIndex)
				val j = if(stack.isNotEmpty()) stack.last() + 1 else 0
				//println(" h = ${heights[k]} w = ${i-j}")
				a = Math.max(a, heights[k] * (i - j))
			}
			stack.add(i)
		}

		while(stack.isNotEmpty()) {
			val k = stack.removeAt(stack.lastIndex)
			val j = if(stack.isNotEmpty()) stack.last() + 1 else 0
			//println(" h = ${heights[k]} w = ${heights.size-j}")
			a = Math.max(a, heights[k] * (heights.size - j))
		}
		return a
	}
}