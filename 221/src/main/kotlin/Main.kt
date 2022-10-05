//https://leetcode.com/problemset/all?search=221
//https://leetcode.com/problems/maximal-square/
class Solution {
	fun maximalSquare(matrix: Array<CharArray>): Int {
		var l = 0
		var m = Array(matrix.size, { IntArray(matrix[it].size) })
		for(i in 0 until matrix.first().size) {
			if (matrix[0][i] == '1') {
				m[0][i] = 1
				l = 1
			}
		}
		for(i in 0 until matrix.size) {
			if (matrix[i][0] == '1') {
				m[i][0] = 1
				l = 1
			}
		}
		for(i in 1 until matrix.size) {
			for(j in 1 until matrix[i].size) {
				if (matrix[i][j] == '0') {
					continue
				}
				var k = Math.min(m[i-1][j-1], Math.min(m[i-1][j], m[i][j-1])) + 1
				l = Math.max(l, k)
				m[i][j] = k
			}
		}
		//m.forEach { println(it.toList()) }
		return l * l
	}
}