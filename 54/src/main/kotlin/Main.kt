//https://leetcode.com/problemset/all?search=54
//https://leetcode.com/problems/spiral-matrix/
class Solution {
	fun spiralOrder(matrix: Array<IntArray>): List<Int> {
		val m = matrix.size
		val n = matrix.first().size
		var s = m * n
		var output = MutableList<Int>(s, { 0 })
		var k = 0
		var j = 0
		while(k < s) {
			val i = j
			j++
			// Left
			var next = true
			for(y in i until n-i) {
				//println("goes to Left")
				output[k++] = matrix[i][y]
				next = false
			}
			if (next) {
				continue
			}
			next = true
			// Down
			for(x in i+1 until m-i) {
				//println("goes to Down")
				output[k++] = matrix[x][n-1-i]
				next = false
			}
			if(next) {
				continue
			}
			// Right to left
			next = true
			for(y in n-1-i-1 downTo i) {
				//println("goes to right")
				output[k++] = matrix[m-1-i][y]
				next = false
			}
			if (next) {
				continue
			}
			// Up
			for(x in m-1-i-1 downTo i+1) {
				//println("goes to up")
				output[k++] = matrix[x][i]
			}
		}
		return output
	}
}