//https://leetcode.com/problems/minimum-path-sum/
class Solution {
	fun minPathSum(grid: Array<IntArray>): Int {
		for(i in 0 until grid.size) {
			for(j in 0 until grid[i].size) {
				var p = -1
				if (i > 0) {
					p = grid[i-1][j]
				}
				if (j > 0) {
					if (p >= 0) {
						p = Math.min(p, grid[i][j-1])
					} else {
						p = grid[i][j-1]
					}
				}
				grid[i][j] += Math.max(p, 0)
			}
		}
		return grid.last().last()			
	}
}