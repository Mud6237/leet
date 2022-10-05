//https://leetcode.com/problemset/all?search=63
//https://leetcode.com/problems/unique-paths-ii/
class Solution {
	fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
		val paths = Array(obstacleGrid.size, { IntArray(obstacleGrid[it].size) })
		var obstacle = 0
		for(i in 0 until paths[0].size) {
			obstacle = obstacle or obstacleGrid[0][i]
			paths[0][i] = obstacle.inv() and 1
		}
		obstacle = 0
		for(i in 0 until paths.size) {
			obstacle = obstacle or obstacleGrid[i][0]
			paths[i][0] = obstacle.inv() and 1
		}
		for(i in 1 until paths.size) {
			for(j in 1 until paths[i].size) {
				if (obstacleGrid[i][j] == 1) {
					paths[i][j] = 0
				} else {
					paths[i][j] = paths[i-1][j] + paths[i][j-1]
				}
			}
		}
		return paths.last().last()
	}
}