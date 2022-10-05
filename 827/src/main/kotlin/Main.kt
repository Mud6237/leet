//https://leetcode.com/problems/making-a-large-island/
class Solution {

	companion object {
		val directions = arrayOf(
			intArrayOf(0, 1),
			intArrayOf(1, 0),
			intArrayOf(0, -1),
			intArrayOf(-1, 0)
		)
	}

	private fun exploreIsland(
		x: Int,
		y: Int,
		grid: Array<IntArray>,
		islandGrid: Array<Array<Island?>>,
		island: Island
	): Int {
		islandGrid[x][y] = island
		var sz = 1
		grid[x][y] = 2
		for(dir in directions) {
			val u = dir.first() + x
			val v = dir.last() + y
			if (u >=0 && u < grid.size && v >= 0 && v < grid[x].size && grid[u][v] == 1) {
				sz += exploreIsland(u, v, grid, islandGrid, island)
				grid[u][v] = 2
			}
		}
		return sz
	}

	private data class Island(var sz: Int)

	fun largestIsland(grid: Array<IntArray>): Int {
		val islandGrid = Array(grid.size, { Array<Island?>(grid[it].size, { null }) })
		var r = Int.MIN_VALUE
		for(i in 0 until grid.size) {
			for(j in 0 until grid[i].size) {
				if (grid[i][j] == 1) {
					val island = Island(0)
					island.sz = exploreIsland(i, j, grid, islandGrid, island)
					r = Math.max(r, island.sz)
				}
			}
		}
		for(i in 0 until grid.size) {
			for(j in 0 until grid[i].size) {
				if (grid[i][j] == 0) {
					val islands = mutableListOf<Island>()
					for(dir in directions) {
						val x = i + dir.first()
						val y = j + dir.last()
						if (x >=0 && x < grid.size && y >= 0 && y < grid[x].size) {
							val island = islandGrid[x][y]
							if (island != null) {
								val res = islands.find { it === island }
								if (res == null) {
									islands.add(island)
								}
							}
						}
					}
					var m = 1
					for(island in islands) {
						m += island.sz
					}
					r = Math.max(r, m)
				}
			}
		}
		return r
	}

}