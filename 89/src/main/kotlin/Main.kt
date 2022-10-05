//https://leetcode.com/problemset/all?search=89
//https://leetcode.com/problems/gray-code/
class Solution {
	fun grayCode(n: Int): List<Int> {
		val result = MutableList<Int>(1 shl n, { 0 })
		result[1] = 1
		for(i in 2..n) {
			val k = (1 shl (i-1))
			val u = k-1
			for(j in u downTo 0) {
				result[k+u-j] = result[j] or k
			}
		}
		return result
	}
}
