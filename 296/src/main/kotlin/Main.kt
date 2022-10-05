//https://leetcode.com/problems/best-meeting-point/
class Solution {
	fun minTotalDistance(grid: Array<IntArray>): Int {
		val rows = mutableListOf<Int>()
		val cols = mutableListOf<Int>()
		for(i in 0 until grid.size) {
			for(j in 0 until grid[i].size) {
				if (grid[i][j] == 1) {
					rows.add(i)
					cols.add(j)
				}
			}
		}
		cols.sort()
		val midRow = rows[rows.size/2]
		val midCol = cols[cols.size/2]
		var totalDistance = 0
		for(r in rows) {
			totalDistance += Math.abs(r - midRow)
		}
		for(c in cols) {
			totalDistance += Math.abs(c - midCol)
		}
		return totalDistance
	}
}