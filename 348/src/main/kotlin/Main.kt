//https://leetcode.com/problems/design-tic-tac-toe/

class TicTacToe(private val n: Int) {
    private val board = Array(n, {  IntArray(n) })
    private val directions = arrayOf(
        intArrayOf(-1, -1),
        intArrayOf(-1, 0),
        intArrayOf(-1, 1),
        intArrayOf(0, -1),
        intArrayOf(0, 1),
        intArrayOf(1, -1),
        intArrayOf(1, 0),
        intArrayOf(1, 1)
    )

    fun isValid(x: Int, y: Int): Boolean {
        if (x >=0 && x < n && y >= 0 && y < n) {
            return true
        } 
        return false
    }

    fun sumAlong(row: Int, col: Int, dir: IntArray): Int {
        var x = row + dir[0]
        var y = col + dir[1]
        var s = 0
        while(isValid(x, y)) {
            s += board[x][y]
            x = x + dir[0]
            y = y + dir[1]
        }
        return s
    }

    fun move(row: Int, col: Int, player: Int): Int {
        val playerSign = if (player == 1) 1 else -1
        board[row][col] = playerSign
        for(i in 0..directions.lastIndex / 2) {
            var r = directions.lastIndex - i
            val s = playerSign + sumAlong(row, col, directions[i]) + sumAlong(row, col, directions[r])
            if (Math.abs(s) == n) {
                return if (s > 0) 1 else 2
            }
        }
        return 0
    }

}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * var obj = TicTacToe(n)
 * var param_1 = obj.move(row,col,player)
 */