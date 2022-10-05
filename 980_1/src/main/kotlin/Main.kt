//https://leetcode.com/problemset/all?search=980
//https://leetcode.com/problems/unique-paths-iii/
class Solution {

	companion object {
		val directions = arrayOf(
			intArrayOf(-1, 0),
			intArrayOf(1, 0),
			intArrayOf(0, -1),
			intArrayOf(0, 1)
		)
	}

	private fun uniquePathsImpl(
		srcX: Int,
		srcY: Int,
		grid: Array<IntArray>,
		destX: Int,
		destY: Int,
		pathlength: Int,
		nonObstacleCount: Int,
		result: IntArray
	) {
		if (srcX == destX && srcY == destY) {
			//println("got to the dest with pathlength = $pathlength")
			if (pathlength == nonObstacleCount) {
				result[0] += 1
			}
			//grid[srcX][srcY] = v
			return
		}
		for(dir in directions) {
			val x = srcX + dir.first()
			val y = srcY + dir.last()
			if (x >=0 && x < grid.size && y >= 0 && y < grid[x].size && grid[x][y] >= 0) {
				val v = grid[x][y]
				grid[x][y] = -1
				uniquePathsImpl(x, y, grid, destX, destY, pathlength + 1, nonObstacleCount, result)
				grid[x][y] = v
			}
		}
		//grid[srcX][srcY] = v
	}

	fun uniquePathsIII(grid: Array<IntArray>): Int {
		var u = 0
		var v = 0
		var x = 0
		var y = 0
		var nonObstacleCount = 0
		for(i in 0 until grid.size) {
			for(j in 0 until grid[i].size) {
				if (grid[i][j] >= 0) {
					nonObstacleCount += 1
					if (grid[i][j] == 1) {
						u = i
						v = j
					} else if (grid[i][j] == 2) {
						x = i
						y = j
					}
				}
			}
		}
		//println("nonObstacleCount = $nonObstacleCount")
		val result = intArrayOf(0)
		grid[u][v] = -1
		uniquePathsImpl(u,v, grid, x, y, 1, nonObstacleCount, result)
		grid[u][v] = 1
		return result.first()
	}
}
