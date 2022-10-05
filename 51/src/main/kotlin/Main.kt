// https://leetcode.com/problems/n-queens/

class Solution {

	class Board private constructor(val n: Int, var b: Array<CharArray> ) {
		constructor(n: Int): this(n, Array(n, { CharArray(n, {'.'})}))

		fun isSafe(row: Int, col: Int) : Boolean {
			var top = col
			var topLeft = col
			var topRight = col
			for(r in row-1 downTo 0) {
				top = top
				topLeft = topLeft - 1
				topRight = topRight + 1
				if(b[r][top] == 'Q' ||
					(topLeft >= 0 && b[r][topLeft] == 'Q') ||
					(topRight < b.size && b[r][topRight] == 'Q')) {
					return false
				}
			}
			return true
		}

		fun placeQueen(row: Int, col: Int) {
			b[row][col] = 'Q'
		}

		fun removeQueen(row: Int, col: Int) {
			b[row][col] = '.'
		}

		override fun toString(): String {
			var sb = StringBuilder()
			sb.setLength((n * n) + n - 1)
			for(row in b) {
				for(col in row) {
					sb.append(col)
				}
				sb.append('\n')
			}
			return sb.toString()
		}

		fun printTo(result: MutableList<List<String>>) {
			result.add(b.map{it.joinToString("")})
		}
	}

	fun solveNQueensImpl(board: Board, n: Int, row: Int, result: MutableList<List<String>>) {
		if (row >= n) {
			board.printTo(result)
			return
		}
		for(col in 0 until n) {
			if (board.isSafe(row, col)) {
				board.placeQueen(row, col)
				solveNQueensImpl(board, n, row+1, result)
				board.removeQueen(row, col)
			}
		}
	}

	fun solveNQueens(n: Int): List<List<String>> {
		val result = mutableListOf<List<String>>()
		val board = Board(n)
		solveNQueensImpl(board, n, 0, result)
		return result
	}
}

fun main(args: Array<String>) {
	println(Solution().solveNQueens(4))
}
