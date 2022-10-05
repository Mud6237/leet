// https://leetcode.com/problemset/all?search=695
// https://leetcode.com/problems/max-area-of-island/
class Solution {
	val directions = arrayOf(intArrayOf(0,1), intArrayOf(1,0), intArrayOf(-1, 0), intArrayOf(0, -1))

	private fun maxAreaOfIslandImpl(grid: Array<IntArray>, i: Int, j: Int, area: IntArray) {
		area[0] += 1
		grid[i][j] = 2
		for(dir in directions) {
			val x = i + dir.first()
			val y = j + dir.last()
			if(x >= 0 && x < grid.size && y >= 0 && y < grid[x].size && grid[x][y] == 1) {
				maxAreaOfIslandImpl(grid, x, y, area)
			}
		}
	}

	fun maxAreaOfIsland(grid: Array<IntArray>): Int {
		var maxSize = 0
		val area = intArrayOf(0)
		for(i in 0 until grid.size) {
			for(j in 0 until grid[i].size) {
				if (grid[i][j] == 1) {
					area[0] = 0
					maxAreaOfIslandImpl(grid, i, j, area)
					maxSize = Math.max(maxSize, area.first())
				}
			}
		}
		return maxSize
	}
}

fun main() {
	val grid1 = arrayOf(intArrayOf(0,0,1,0,0,0,0,1,0,0,0,0,0),intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),intArrayOf(0,1,1,0,1,0,0,0,0,0,0,0,0),intArrayOf(0,1,0,0,1,1,0,0,1,0,1,0,0),intArrayOf(0,1,0,0,1,1,0,0,1,1,1,0,0),intArrayOf(0,0,0,0,0,0,0,0,0,0,1,0,0),intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),intArrayOf(0,0,0,0,0,0,0,1,1,0,0,0,0))
	println(Solution().maxAreaOfIsland(grid1))
	val grid2 = arrayOf(intArrayOf(0,0,0,0,0,0,0,0))
	println(Solution().maxAreaOfIsland(grid2))
}
