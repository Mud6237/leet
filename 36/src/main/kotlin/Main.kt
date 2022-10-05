//https://leetcode.com/problemset/all?search=36
class Solution {
	fun isValidSudoku(board: Array<CharArray>): Boolean {
		val rows = IntArray(board.size, { 0 })
		val cols = IntArray(board.size, { 0 })
		val grid = IntArray(board.size, { 0 })
		for(i in 0 until board.size) {
			for(j in 0 until board[i].size) {
				if (board[i][j] == '.') {
					continue
				}
				val n = board[i][j] - '0'
				if (n == 0) {
					return false
				}
				val m = 1 shl n
				val r = rows[i]
				if (m or r == r) {
					return false
				}
				rows[i] = m or r
				val c = cols[j]
				if (m or c == c) {
					return false
				}
				cols[j] = m or c
				val gi = i / 3
				var gj = j / 3
				val k = (gi * 3) + gj
				val g = grid[k]
				if (m or g == g) {
					return false
				}
				grid[k] = m or g
			}
		}
		return true
	}
}