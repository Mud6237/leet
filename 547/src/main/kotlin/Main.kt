//https://leetcode.com/problemset/all?search=547
//https://leetcode.com/problems/number-of-provinces/
class Solution {

	fun findCircleNum(isConnected: Array<IntArray>): Int {
		var n = isConnected.size
		val marked = IntArray(n)
		val stack = mutableListOf<Int>()
		var count = 0
		for(i in 0 until n) {
			if (marked[i] == 0) {
				stack.add(i)
				marked[i] = 1
				count += 1
				while(stack.isNotEmpty()) {
					outer@while(true) {
						val top = stack.last()
						for((idx, v) in isConnected[top].withIndex()) {
							if (idx != top && v == 1 && marked[v] == 0) {
								marked[v] = 1
								stack.add(v)
								continue@outer
							}
						}
						break
					}
					stack.removeLast()
				}
			}
		}
		return count
	}
}
fun main() {
	var isConnected = arrayOf(intArrayOf(1,1,0),intArrayOf(1,1,0),intArrayOf(0,0,1))
	println(Solution().findCircleNum(isConnected))
	isConnected = arrayOf(intArrayOf(1,0,0),intArrayOf(0,1,0),intArrayOf(0,0,1))
	println(Solution().findCircleNum(isConnected))
}
