//https://leetcode.com/problemset/all?search=980
//https://leetcode.com/problems/unique-paths-iii/

class Solution {

	fun traverse(grid: Array<IntArray>, i: Int, j: Int, c: Int, s: Int, res: IntArray) {
		if (grid[i][j] == 2) {
			if (c == s) {
				res[0] += 1
			}
			return
		}
		val k = grid[i][j]
		grid[i][j] = -2
		if(i > 0 && grid[i-1][j] >= 0) {
			traverse(grid, i-1, j, c+1, s, res)
		}
		if (i < grid.lastIndex && grid[i+1][j] >= 0) {
			traverse(grid, i+1, j, c+1, s, res)
		}
		if (j > 0 && grid[i][j-1] >= 0) {
			traverse(grid, i, j-1, c+1, s, res)
		}
		if (j < grid[i].lastIndex && grid[i][j+1] >= 0) {
			traverse(grid,i, j+1, c+1, s, res)
		}
		grid[i][j] = k
	}

	fun uniquePathsIII(grid: Array<IntArray>): Int {
		var sx = 0
		var sy = 0
		var emtpyCount = grid.size * grid.first().size
		var cache = Array(grid.size, { IntArray(grid.first().size, { Int.MIN_VALUE }) })
		for(i in 0..grid.lastIndex) {
			for(j in 0..grid[i].lastIndex) {
				if (grid[i][j] == -1) {
					emtpyCount -= 1
				} else if (grid[i][j] == 1) {
					sx = i
					sy = j
				}
			}
		}
		val r = intArrayOf(0)
		traverse(grid, sx, sy, 1, emtpyCount, r)
		return r.first()
	}
}

fun main(args: Array<String>) {
	val grid = arrayOf(intArrayOf(1,0,0,0),intArrayOf(0,0,0,0),intArrayOf(0,0,2,-1))
	println(Solution().uniquePathsIII(grid))
}
