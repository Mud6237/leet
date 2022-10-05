//https://leetcode.com/problemset/all?search=994
//https://leetcode.com/problems/rotting-oranges/

class Solution {
	fun orangesRotting(grid: Array<IntArray>): Int {
		val queue = ArrayDeque<Pair<Int, Int>>()
		val m = grid.size
		if (m < 1) {
			return 0
		}
		val n = grid.first().size
		if (n < 1) {
			return 0
		}
		var freshOrangesCount = 0
		for(i in 0 until m) {
			for(j in 0 until n) {
				if (grid[i][j] == 2) {
					queue.addLast(Pair(i, j))
				} else if (grid[i][j] == 1) {
					freshOrangesCount += 1
				}
			}
		}
		if (freshOrangesCount == 0) {
			return 0
		}
		val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1))
		var levels = -1
		while(queue.isNotEmpty()) {
			//grid.forEach { println(it.toList())}
			repeat(queue.size) {
				val front = queue.removeFirst()
				for(dir in directions) {
					val x = dir.first() + front.first
					val y = dir.last() + front.second
					if (x >=0 && x < grid.size && y >= 0 && y < grid[x].size && grid[x][y] == 1) {
						freshOrangesCount -= 1
						grid[x][y] = 2
						queue.addLast(Pair(x, y))
					}
				}
			}
			levels += 1
			//println()
		}
		return if (freshOrangesCount == 0) levels else -1
	}
}

