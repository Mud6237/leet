//https://leetcode.com/problemset/all?search=909
//https://leetcode.com/problems/snakes-and-ladders/
class Solution {
	companion object {
		fun numToIndex(n: Int, m: Int): Pair<Int,Int> {
			val r = (n-1) / m
			val row = (m - 1) - r
			val c = (n - 1) % m
			val col = if (r % 2 == 0) c else (m - 1) - c
			return Pair(row, col)
		}
	}

	fun snakesAndLadders(board: Array<IntArray>): Int {
		val queue = ArrayDeque<Int>()
		queue.addLast(1)
		val m = board.size
		val dest = m * m
		var level = 0
		while(queue.isNotEmpty()) {
			repeat(queue.size) {
				val currentPos = queue.removeFirst()
				if (currentPos == dest) {
					return level 
				}
				val nextMoves = Math.min(currentPos + 6, dest)
				for(nextMove in (currentPos+1)..nextMoves) {
					val (x, y) = numToIndex(nextMove, m)
					var b = board[x][y]
					if (b >= -1) {
						b = if (b < 0) nextMove else b
						queue.addLast(b)
					}
					board[x][y] = -2
				}
			}
			level += 1
		}
		return -1
	}
}