//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
class Solution {
	fun longestIncreasingPath_incorrect(matrix: Array<IntArray>): Int {
		var r = Int.MIN_VALUE
		val a = Array(matrix.size, { index -> Array(matrix[index].size, { intArrayOf(0, 0) } ) })

		for(i in 0 until matrix.size) {
			for(j in 0 until matrix[i].size) {
				if (i > 0) {
					if (matrix[i][j] > matrix[i-1][j]) {
						a[i][j][1] = Math.max(a[i][j][1], a[i-1][j][1] + 1)
					} else if (matrix[i][j] < matrix[i-1][j]) {
						a[i][j][0] = Math.max(a[i][j][0], a[i-1][j][0] + 1)
					}
				}
				if (j > 0) {
					if (matrix[i][j] > matrix[i][j-1]) {
						a[i][j][1] = Math.max(a[i][j][1], a[i][j-1][1] + 1)
					} else if (matrix[i][j] < matrix[i][j-1]) {
						a[i][j][0] = Math.max(a[i][j][0], a[i][j-1][0] + 1)
					}
				}
			}
		}

		//println("Forward:")
		//a.forEach { m -> m.forEach { print(it.toList()) } 
		//	println()
		//}

		for(i in matrix.lastIndex downTo 0) {
			for(j in matrix[i].lastIndex downTo 0) {
				if (i < matrix.lastIndex) {
					if (matrix[i][j] > matrix[i+1][j]) {
						a[i][j][1] = Math.max(a[i][j][1], a[i+1][j][1] + 1)
					} else if (matrix[i][j] < matrix[i+1][j]) {
						a[i][j][0] = Math.max(a[i][j][0], a[i+1][j][0] + 1)
					}
				}
				if (j < matrix[i].lastIndex) {
					if (matrix[i][j] > matrix[i][j+1]) {
						a[i][j][1] = Math.max(a[i][j][1], a[i][j+1][1] + 1)
					} else if (matrix[i][j] < matrix[i][j+1]) {
						a[i][j][0] = Math.max(a[i][j][0], a[i][j+1][0] + 1)
					}
				}
				r = Math.max(r, a[i][j][0] + a[i][j][1])
			}
		}
		//println("Reverse:")
		//a.forEach { m -> m.forEach { print(it.toList()) } 
		//	println()
		//}
		return r + 1
	}

	companion object {
		val Directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
	}

	fun longestIncreasingPathImpl(matrix: Array<IntArray>, memo: Array<IntArray>, i: Int, j: Int) : Int {
		if (memo[i][j] > 0) {
			return memo[i][j]
		}
		val c = matrix[i][j]
		matrix[i][j] = -1
		var m = 1
		for(dir in Directions) {
			val (iOffset, jOffset) = dir
			val x = i + iOffset
			val y = j + jOffset
			if(x >= 0 && x <= matrix.lastIndex && y >= 0 && y <= matrix[x].lastIndex && matrix[x][y] > c ) {
				m = Math.max(m, longestIncreasingPathImpl(matrix, memo, x, y) + 1)
			}
		}
		matrix[i][j] = c
		memo[i][j] = m
		return m
	}

	fun longestIncreasingPath(matrix: Array<IntArray>): Int {
		var longestPathLength = 0
		val memo = Array(matrix.size, { IntArray(matrix[it].size) })
		for(i in 0..matrix.lastIndex)  {
			for(j in 0..matrix[i].lastIndex) {
				longestPathLength = Math.max(longestPathLength, longestIncreasingPathImpl(matrix, memo, i, j))
			}
		}
		return longestPathLength
	}
}
fun main() {
	
}
