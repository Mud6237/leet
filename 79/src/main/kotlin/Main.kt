//https://leetcode.com/problemset/all?search=79
//https://leetcode.com/problems/word-search/
class Solution {
	companion object {
		val directions = arrayOf(
			intArrayOf(1, 0),
			intArrayOf(-1, 0),
			intArrayOf(0, 1),
			intArrayOf(0, -1)
		)
	}

	private fun existsImpl(
		board: Array<CharArray>,
		word: String,
		i: Int, 
		j: Int,
		k: Int
	): Boolean {
		if (board[i][j] != word[k]) {
			return false
		}
		if (k == word.lastIndex && board[i][j] == word.last()) {
			return true
		}
		val c = board[i][j]
		board[i][j] = '1'
		var found = false
		for(dir in directions) {
			val x = i + dir.first()
			val y = j + dir.last()
			val m = k + 1
			if (!found && x >= 0 && x < board.size && y >= 0 && y < board[x].size && m < word.length && board[x][y] != '1') {
				found = existsImpl(board, word, x, y, m)
			}
		}
		board[i][j] = c
		return found
	}
		
	fun exist(board: Array<CharArray>, word: String): Boolean {
		for(i in 0 until board.size) {
			for(j in 0 until board[i].size) {
				if (existsImpl(board, word, i, j, 0)) {
					return true
				}
			}
		}
		return false
	}
}
