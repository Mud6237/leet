//https://leetcode.com/problemset/all?search=289
//https://leetcode.com/problems/game-of-life/
class Solution {
	
	companion object { 
		val directions = arrayOf(
			intArrayOf(0, 1),
			intArrayOf(1, 0),
			intArrayOf(-1, 0),
			intArrayOf(0, -1),
			intArrayOf(1, 1),
			intArrayOf(-1, -1),
			intArrayOf(-1, 1),
			intArrayOf(1, -1),
		)
		fun addDirection(a: IntArray, b: IntArray): IntArray {
			return intArrayOf(a.first() + b.first(), a.last() + b.last())
		}
		fun isLive(m: Array<IntArray>, b: IntArray): Boolean {
			val x = b.first()
			val y = b.last()
			if (x >= 0 && x < m.size && y >= 0 && y < m[x].size && m[x][y] == 1) {
				return true
			}
			return false
		}
	}

	fun liveNeighborCount(b: Array<IntArray>, p: IntArray): Int {
		var c = 0
		for(dir in directions) {
			if (isLive(b, addDirection(p, dir))) {
				c += 1
			}
		}
		return c
	}
	
	fun gameOfLife(board: Array<IntArray>): Unit {
		val boardClone = Array(board.size, { board[it].copyOf()})
		for(i in 0 until board.size) {
			for(j in 0 until board[i].size) {
				val c = liveNeighborCount(boardClone, intArrayOf(i, j))
				if (boardClone[i][j] == 1) {
					if (c < 2 || c > 3 ) {
						board[i][j] = 0
					}
				} else {
					if (c == 3) {
						board[i][j] = 1
					}
				}
			}
		}
		board.forEach { println(it.toList()) }
	}
}
fun main() {
	Solution().gameOfLife(
		arrayOf(intArrayOf(0,1,0),intArrayOf(0,0,1),intArrayOf(1,1,1),intArrayOf(0,0,0))
	)
	Solution().gameOfLife(
		arrayOf(intArrayOf(1,1),intArrayOf(1, 0))
	)
	
}
