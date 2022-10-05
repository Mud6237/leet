//https://leetcode.com/problems/number-of-distinct-islands/
class Solution {
	companion object {
		var directions = arrayOf(
			intArrayOf(0, -1) to 'L',
			intArrayOf(0,  1) to 'R',
			intArrayOf(-1, 0) to 'U',
			intArrayOf(1,  0) to 'D'
		)
	}

	private fun numDistinctIslandsImpl(grid: Array<IntArray>, i: Int, j: Int, sb: StringBuilder) {
		grid[i][j] = 0
		for((dir, dirStr) in directions) {
			var x = i + dir[0]
			var y = j + dir[1]
			if (x >= 0 && x < grid.size && y >= 0 && y < grid[x].size && grid[x][y] == 1) {
				sb.append(dirStr)
				numDistinctIslandsImpl(grid, x, y, sb)
				sb.append('B')
			}
		}
	}

	fun numDistinctIslands(grid: Array<IntArray>): Int {
		val hs = hashSetOf<String>()
		var count = 0
		var sb = StringBuilder()
		for(i in 0 until grid.size) {
			for(j in 0 until grid[i].size) {
				if (grid[i][j] == 1) {
					sb.clear()
					sb.append('S')
					numDistinctIslandsImpl(grid, i, j, sb)
					val s = sb.toString()
					count += if(hs.add(s)) 1 else 0
				}
			}
		}
		return count
	}
}