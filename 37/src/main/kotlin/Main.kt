// https://leetcode.com/problemset/all?search=37
// https://leetcode.com/problems/sudoku-solver/

class Solution {
	class BoardState(
		val rows:IntArray = IntArray(9),
		val cols:IntArray = IntArray(9),
		val boxes:IntArray = IntArray(9),
	)

	fun setBoardState(i: Int, j: Int, boardState: BoardState, bitIndex: Int) {
		val boxIndex = (i / 3) * 3 + (j / 3)
		val m = 1 shl (bitIndex - 1)
		boardState.rows[i] = boardState.rows[i] or m
		boardState.cols[j] = boardState.cols[j] or m
		boardState.boxes[boxIndex] = boardState.boxes[boxIndex] or m
	}

	fun unSetBoardState(i: Int, j: Int, boardState: BoardState, bitIndex: Int) {
		val boxIndex = (i / 3) * 3 + (j / 3)
		val m = 1 shl (bitIndex - 1)
		boardState.rows[i] = boardState.rows[i] and (boardState.rows[i] xor m)
		boardState.cols[j] = boardState.cols[j] and (boardState.cols[j] xor m)
		boardState.boxes[boxIndex] = boardState.boxes[boxIndex] and (boardState.boxes[boxIndex] xor m)
	}



	fun initialState(board: Array<CharArray>): BoardState {
		val boardState = BoardState()
		var boxIndex = -3
		for(i in 0 until board.size) {
			boxIndex += if(i % 3 == 0) 3 else 0
			for (j in 0 until board.size) {
				if (board[i][j] != '.') {
					setBoardState(i, j, boardState, (board[i][j] - '0').toInt())
				}
			}
		}
		return boardState
	}
	fun printState(state: BoardState) {
		println("By Rows:")
		state.rows.forEach{ println(it.toString(2))}
		println("By Cols:")
		state.cols.forEach{ println(it.toString(2))}
		println("By Boxes: top-left to bottom-right")
		state.boxes.forEach{ println(it.toString(2))}
	}

	class StackState (
		var i: Int,
		var j: Int,
		var c : Int
	)

	fun nextCandidateOffSet(i: Int, j: Int, c: Int, boardState: BoardState): Int {
		val boxIndex = (i / 3) * 3 + (j / 3)
		for(v in (1 + c)..9) {
			val m = 1 shl (v - 1)
			if ((boardState.rows[i] and m == 0) && (boardState.cols[j] and m == 0) && (boardState.boxes[boxIndex] and m == 0)) {
				return v
			} 
		}
		return 0
	}

	

	fun solveSudoku(board: Array<CharArray>): Unit {
		val boardState = initialState(board)
		//printState(boardState)
		val stack = mutableListOf<StackState>()
		var i = 0
		val sentinelTop = StackState(-1, -1, 0)
		var lastTop = sentinelTop
		var j = 0
		while(i < board.size) {
			j = if (j >= board.size) 0 else j
			while(j < board.size) {
				if (board[i][j] == '.') {
					val nextNumber = nextCandidateOffSet(i, j, lastTop.c, boardState)
					//println("next number of $i, $j = $nextNumber")
					if (nextNumber > 0) {
						board[i][j] = '0' + nextNumber
						stack.add(StackState(i, j, nextNumber))
						setBoardState(i, j, boardState, nextNumber)
						lastTop = sentinelTop
					} else {
						lastTop = stack.removeLast()
						//println("Removing $lastTop from stack")
						board[lastTop.i][lastTop.j] = '.'
						unSetBoardState(lastTop.i, lastTop.j,  boardState, lastTop.c)
						i = lastTop.i
						j = lastTop.j
						continue 
					}
					//printState(boardState)
				}
				j += 1
			}
			i += 1
		}
		//println("board:")
		//board.forEach { println(it.toList())}
	}
}

fun main() {
	println("Hello World!")
}
