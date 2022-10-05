//https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/

import java.util.PriorityQueue

class Solution {

	companion object {
		val directions = arrayOf(
			intArrayOf(0, 1),
			intArrayOf(1, 0),
			intArrayOf(-1, 0),
			intArrayOf(0, -1)
		)
		val comparator = compareBy<Triple<Int, Int, Int>>({ it.third })
	}

	fun minimumObstaclesImpl(
		grid: Array<IntArray>
	): Int {
		val dp = Array(grid.size,  {IntArray(grid[it].size, { Int.MAX_VALUE })})
		val s = grid.first().first()
		dp[0][0] = s
		var pq = PriorityQueue<Triple<Int, Int, Int>>(comparator)
		pq.add(Triple(0, 0, s))
		while(pq.isNotEmpty()) {
			val nextPq = PriorityQueue(comparator)
			while(pq.isNotEmpty()) {
				val (i, j, k) = pq.poll()
				for(dir in directions) {
					val x = i + dir[0]
					val y = j + dir[1]
					if (x >= 0 && x < grid.size && y >= 0 && y < grid[x].size) {
						val z = k + grid[x][y]
						if (z < dp[x][y]) {
							dp[x][y] = z
							nextPq.add(Triple(x, y, z))
						}
					}
				}
			}
			pq = nextPq
		}
		return dp.last().last()
	}

	fun minimumObstacles(grid: Array<IntArray>): Int {
		return minimumObstaclesImpl(grid)
	}
}
