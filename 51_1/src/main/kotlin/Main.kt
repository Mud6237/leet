//https://leetcode.com/problems/n-queens/
class Solution {
	companion object {
		val directions = arrayOf(
			intArrayOf(-1, -1),
			intArrayOf(1, 1),
			intArrayOf(1, -1),
			intArrayOf(-1, 1)
		)
	}
	private fun canPlace(r: Int, c: Int, board: Array<CharArray>): Boolean {
		for(i in 0 until board.size) {
			if (board[r][i] == 'Q') {
				return false
			}
			if(board[i][c] == 'Q') {
				return false
			}
		}
		for(dir in directions) {
			var x = r
			var y = c
			while(x >= 0 && x < board.size && y >= 0 && y < board.size) {
				if (board[x][y] == 'Q') {
					return false
				}
				x += dir[0]
				y += dir[1]
			}
		}
		return true
	}

	private fun solveNQueensImpl(i: Int, n: Int, board: Array<CharArray>, result: MutableList<List<String>>) {
		if(i >= n) {
			result.add(board.map{ it.joinToString("") }.toList())
			return
		}
		for(j in 0 until n) {
			if(canPlace(i, j, board)) {
				board[i][j] = 'Q'
				solveNQueensImpl(i+1, n, board, result)
				board[i][j] = '.'
			}
		}
	}

	fun solveNQueens(n: Int): List<List<String>> {
		val board = Array(n, { CharArray(n, { '.' }) })
		val result = mutableListOf<List<String>>()
		solveNQueensImpl(0, n, board, result)
		return result
	}
}