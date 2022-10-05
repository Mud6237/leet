//https://leetcode.com/problemset/all?search=773
//https://leetcode.com/problems/sliding-puzzle/

class Solution {
	fun hashCode(board: Array<IntArray>): Int {
		var h = board[0][0] * 31
		h = (h + board[0][1] * 1) * 31
		h = (h + board[0][2] * 2) * 31
		h = (h + board[1][0] * 3) * 31
		h = (h + board[1][1] * 4) * 31
		h = (h + board[1][2] * 5) * 31
		return h
	}

	fun boardToStr(board: Array<IntArray>): String {
		var s = ByteArray(6)
		s[0] = (97 + board[0][0]).toByte()
		s[1] = (97 + board[0][1]).toByte()
		s[2] = (97 + board[0][2]).toByte()
		s[3] = (97 + board[1][0]).toByte()
		s[4] = (97 + board[1][1]).toByte()
		s[5] = (97 + board[1][2]).toByte()
		return s.toString(Charsets.UTF_8)
	}


	fun isSolved(board: Array<IntArray>): Boolean {
		return (
			board[0][0] == 1 && 
			board[0][1] == 2 && 
			board[0][2] == 3 && 
			board[1][0] == 4 && 
			board[1][1] == 5 && 
			board[1][2] == 0
		)
	}

	fun swap(b: Array<IntArray>, i: Int, j: Int, x: Int, y: Int) {
		val t = b[i][j]
		b[i][j] = b[x][y]
		b[x][y] = t
	}

	fun slidingPuzzle(board: Array<IntArray>): Int {
		val queue = ArrayDeque<Pair<Array<IntArray>, Pair<Int, Int>>>()
		var i = 0
		var j = 0
		outer@while(i < board.size) {
			j = 0
			while(j < board[i].size) {
				if (board[i][j] == 0) {
					break@outer
				}
				j += 1
			}
			i += 1
		}
		val visited = hashSetOf<String>()
		queue.addLast(Pair(board, Pair(i, j)))
		var dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1))
		var level = 0
		while(queue.isNotEmpty()) {
			//println("Level = ${level} queue size = ${queue.size} visited=${visited}")
			repeat(queue.size) {
				val (b, c) = queue.removeFirst()
				if (isSolved(b)) {
					//println("Found Ansser")
					return level
				}
				//b.forEach { print(it.toList())} 
				//println()
				visited.add(boardToStr(b))
				var (p, q) = c
				for(dir in dirs) {
					val x = dir[0] + p
					val y = dir[1] + q
					if (x >=0 && x < b.size && y >= 0 && y < b[x].size ) {
						swap(b, p, q, x, y)
						//println("swapping ($p, $q), ($x, $y)")
						//println(" boardToStr of new = ${boardToStr(b)} visited = ${visited.contains(boardToStr(b))} ")
						//b.clone().forEach{print(it.toList())}
						//println()
						val h = boardToStr(b)
						if (!visited.contains(h)) {
							val cc = b.copyOf()
							for(w in 0 until cc.size) {
								cc[w] = cc[w].copyOf()
							}
							queue.addLast(Pair(cc, Pair(x, y)))
						} 
						//else {
						//	print("already visited: ${h}")
						//	b.forEach{print(it.toList())}
						//	println()
						//}
						swap(b, x, y, p, q)
					}
				}
			}
			level += 1
		}	
		return -1
	}
}

fun main() {
	var a = arrayOf(intArrayOf(4, 1, 2), intArrayOf(5, 0, 3))
	println(Solution().slidingPuzzle(a))
	a = arrayOf(intArrayOf(1,2,3),intArrayOf(5,4,0))
	println(Solution().slidingPuzzle(a))
	a = arrayOf(intArrayOf(1,2,3),intArrayOf(4,0,5))
	println(Solution().slidingPuzzle(a))
}