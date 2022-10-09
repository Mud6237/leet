//https://leetcode.com/problems/word-search-ii/

class TrieNode(
    val next: Array<TrieNode?> = Array<TrieNode?>(26, { null }),
    var word: String? = null
)

class Solution {

    val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, -1)
    )

    companion object {
        fun toIndex(c: Char): Int = c - 'a'
        fun buildTrie(words: Array<String>): TrieNode {
            val root = TrieNode()
            for(word in words) {
                var node = root
                for(c in word) {
                    val i = toIndex(c)
                    val n = node.next[i] ?: TrieNode()
                    node.next[i] = n
                    node = n
                }
                node.word = word
            }
            return root
        }
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int, node: TrieNode, res: MutableList<String>) {
        val c = board[i][j]
        if(c == '#') {
            return
        }
        val idx = toIndex(c)
        val q = node.next[idx] ?: return
        val w = q.word
        if (w != null) {
            res.add(w)
            q.word = null
        }
        board[i][j] = '#'
        for(dir in directions) {
            val x = dir.first() + i
            val y = dir.last() + j
            if(x >= 0 && x < board.size && y >= 0 && y < board[x].size) {
                dfs(board, x, y, q, res)
            }
        }
        board[i][j] = c
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val res = mutableListOf<String>()
        val root = buildTrie(words)
        for(i in 0 until board.size) {
            for(j in 0 until board[i].size) {
                dfs(board, i, j, root, res)
            }
        }
        return res
	}
}

