//https://leetcode.com/problemset/all?search=739
//https://leetcode.com/problems/daily-temperatures/
class Solution {
	fun dailyTemperatures(temperatures: IntArray): IntArray {
		val result = IntArray(temperatures.size)
		val stack = mutableListOf<Int>()
		for((index, t) in temperatures.withIndex()) {
			//println("t = $t")
			while(stack.isNotEmpty() && temperatures[stack.last()] < t) {
				result[stack.last()] = index - stack.last()
				//println("removing ${temperatures[stack.last()]} size = ${index - stack.last()} ")
				stack.removeAt(stack.lastIndex)
			}
			stack.add(index)
		}
		return result	
	}
}