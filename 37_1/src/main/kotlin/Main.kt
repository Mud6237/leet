//https://leetcode.com/problems/sudoku-solver/
class Solution {

	private fun gridIndex(row: Int, col: Int): Int {
		return (row / 3) * 3 + (col / 3)
	}
	
	private fun printBoard(board: Array<CharArray>) {
		println(board.map { it.joinToString(",") }.joinToString("\n"))
	}

	private fun solveSudokuImpl(
		i: Int,
		j: Int,
		board: Array<CharArray>,
		rows: IntArray,
		cols: IntArray,
		grid: IntArray
	): Boolean {
		if (i >= board.size) {
			//println("never hit here")
			return true
		}
		var k = j
		while(k < board.size && board[i][k] != '.') {
			k += 1
		}
		if(k < board.size) {
			val r = rows[i]
			val c = cols[k]
			val gIndex = gridIndex(i, k)
			val g = grid[gIndex]
			for(n in 1..9) {
				val mask = 1 shl n-1
				val rowNotSet = (r and mask) == 0
				val colNotSet = (c and mask) == 0
				val gridNotSet = (g and mask) == 0
				//println(" ($i, $k) n = $n rowNotSet = $rowNotSet, colNotSet = $colNotSet gridNotSet = $gridNotSet")
				if(rowNotSet && colNotSet && gridNotSet) {
					board[i][k] = '0' + n
					rows[i] = r or mask
					cols[k] = c or mask
					grid[gIndex] = g or mask
					if(solveSudokuImpl(i, k+1, board, rows, cols, grid)) {
						return true
					}
				}
			}
			//println("board\n")
			//printBoard(board)
			//println()
			board[i][k] = '.'
			rows[i] = r
			cols[k] = c
			grid[gIndex] = g
			return false
		}
		return solveSudokuImpl(i+1, 0, board, rows, cols, grid)
	}

	fun solveSudoku(board: Array<CharArray>): Unit {
		val rows = IntArray(board.size)
		val cols = IntArray(board.size)
		val grid = IntArray(board.size)
		for(i in 0 until board.size) {
			for(j in 0 until board.size) {
				val n = board[i][j] - '0'
				val m = 1 shl n-1
				rows[i] = rows[i] or m
				cols[j] = cols[j] or m
				val g = gridIndex(i, j)
				grid[g] = grid[g] or m
			}
		}
		solveSudokuImpl(0, 0, board, rows, cols, grid)
	}
}