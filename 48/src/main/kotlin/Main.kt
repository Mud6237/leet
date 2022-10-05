//https://leetcode.com/problemset/all?search=48
//https://leetcode.com/problems/rotate-image/

class Solution {
	fun rotate(matrix: Array<IntArray>): Unit {
		var m = matrix.size
		for(i in 0 until m / 2) {
			for(j in i until matrix.lastIndex - i) {
				// top right
				var r = j
				var c = matrix.lastIndex - i
				val topRight = matrix[r][c]
				matrix[r][c] = matrix[i][j]
				// bottom right
				r = c
				c = matrix.lastIndex - j
				val bottomRight = matrix[r][c]
				matrix[r][c] = topRight
				// bottom left
				r = c
				c = i
				val bottomLeft = matrix[r][c]
				matrix[r][c] = bottomRight
				// top Left
				matrix[i][j] = bottomLeft
			}
		}
	}
}
