//https://leetcode.com/problems/path-with-maximum-minimum-value/
//https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/324923/Clear-Code-Dijkstra-Algorithm-(C%2B%2BJavaPythonGoPHP)
import java.util.PriorityQueue

class Solution {
	fun maximumMinimumPath(grid: Array<IntArray>): Int {
		val pq = PriorityQueue<IntArray>() {a, b -> b.last() - a.last()}
		pq.add(intArrayOf(0, 0, grid[0][0]))
		var m = Int.MAX_VALUE
		val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1))
		grid[0][0] = -1
		while(pq.isNotEmpty()) {
			val (i, j, k) = pq.poll()
			m = Math.min(m, k)
			if (i == grid.lastIndex && j == grid[i].lastIndex) {
				break
			}
			for(dir in directions) {
				val x = i + dir.first()
				val y = j + dir.last()
				if (x >= 0 && y >=0 && x < grid.size && y < grid[i].size && grid[x][y] >= 0) {
					pq.add(intArrayOf(x, y, grid[x][y]))
					grid[x][y] = -1
				}
			}
		}
		return m
	}
}

fun main() {
	val grid1 = arrayOf(intArrayOf(5,4,5),intArrayOf(1,2,6),intArrayOf(7,4,6))
	println(Solution().maximumMinimumPath(grid1))
	val grid2 = arrayOf(intArrayOf(2,2,1,2,2,2),intArrayOf(1,2,2,2,1,2))
	println(Solution().maximumMinimumPath(grid2))
	val grid3 = arrayOf(intArrayOf(3,4,6,3,4),intArrayOf(0,2,1,1,7),intArrayOf(8,8,3,2,7),intArrayOf(3,2,4,9,8),intArrayOf(4,1,2,0,0),intArrayOf(4,6,5,4,3))
	println(Solution().maximumMinimumPath(grid3))
	val grid4 = arrayOf(intArrayOf(2,0,5,2,0),intArrayOf(2,4,4,4,3),intArrayOf(1,5,0,0,0),intArrayOf(5,4,4,3,1),intArrayOf(1,3,1,5,3))
	println(Solution().maximumMinimumPath(grid4))
	val grid5 = arrayOf(intArrayOf(0,0,0,0,0,1,0),intArrayOf(0,1,0,1,1,0,1),intArrayOf(0,1,1,1,1,0,0),intArrayOf(0,1,0,0,0,0,0),intArrayOf(1,0,0,0,0,0,0),intArrayOf(1,0,0,0,0,0,1))
	println(Solution().maximumMinimumPath(grid5))
	val grid6 = arrayOf(intArrayOf(5,4,3,1),intArrayOf(7,4,5,2),intArrayOf(4,9,8,2),intArrayOf(2,3,6,6),)
	println(Solution().maximumMinimumPath(grid6))
}

// [2,0,5,2,0]
// [2,4,4,4,3]
// [1,5,0,0,0]
// [5,4,4,3,1]
// [1,3,1,5,3]


// [3,4,6,3,4]
// [0,2,1,1,7]
// [8,8,3,2,7]
// [3,2,4,9,8]
// [4,1,2,0,0]
// [4,6,5,4,3]

// [5,4,3,1]
// [7,4,5,2]
// [4,9,8,2]
// [2,3,6,6]
