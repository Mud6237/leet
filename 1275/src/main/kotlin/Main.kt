//https://leetcode.com/problemset/all?search=1275
//https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
class Solution {
	fun tictactoe(moves: Array<IntArray>): String {
		val boardSize = 3
		val boardLastIndex = boardSize - 1

		val aRow = IntArray(3)
		val aCol = IntArray(3)
		var aDig = IntArray(2)
	
		val bRow = IntArray(3)
		val bCol = IntArray(3)
		val bDig = IntArray(2)

		for(i in 0 until moves.size) {
			val x = moves[i][0]
			val y = moves[i][1]
			var row = aRow
			var col = aCol
			var dig = aDig
			if (i % 2 != 0) {
				row = bRow
				col = bCol
				dig = bDig
			}
			row[x] += 1
			col[y] += 1
			if (x == y) {
				dig[0] += 1
			}
			if (x + y == boardLastIndex) {
				dig[1] += 1
			}
			if (
				row[x] == boardSize ||
				col[y] == boardSize ||
				dig[0] == boardSize ||
				dig[1] == boardSize
			) {
				return if (i % 2 == 0) "A" else "B"
			}
		}
		if (moves.size < boardSize * boardSize) {
			return "Pending"
		}
		//println("A row = ${aRow.toList()} A col = ${aCol.toList()} A dig = ${aDig.toList()}")
		//println("B row = ${bRow.toList()} B col = ${bCol.toList()} B dig = ${bDig.toList()}")
		return "Draw"
	}
}