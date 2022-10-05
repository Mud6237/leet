// https://leetcode.com/problems/word-search-ii/
class Solution {
    class TrieNode(
        val d: Array<TrieNode?> = Array<TrieNode?>(26, { null }),
        var s: String = ""
    )
    class Trie(val root: TrieNode = TrieNode()) {
        companion object {
            fun toIndex(c: Char): Int {
                return c - 'a'
            }
        }
        class Iter constructor(var n: TrieNode) {
            fun next(c: Char): Iter? {
                val nextNode = n.d[toIndex(c)] ?: return null
                return Iter(nextNode)
            }

            fun word(): String {
                return n.s
            }
            
            fun resetWord() = n.apply {
                s = ""
            }
        }
        fun add(s: String) {
            var n = root
            for(c in s) {
                val index = toIndex(c)
                val a = n.d[index] ?: TrieNode()
                n.d[index] = a
                n = a
            }
            n.s = s
        }
        fun add(s: Array<String>) = s.forEach{ add(it) }

        fun iter(): Iter = Iter(root)

    }

    private fun findWordsImpl(board: Array<CharArray>, i: Int, j: Int, iter: Trie.Iter, result: MutableList<String>) {
        val c = if(board[i][j] == '#' ) return else board[i][j]
        val nextIter = iter.next(c) ?: return
        val nextIterWord = nextIter.word()
        if (nextIterWord.isNotEmpty()) {
            result.add(nextIter.word())
            nextIter.resetWord()
        }
        board[i][j] = '#'
        if (i > 0) {
            findWordsImpl(board, i-1, j, nextIter, result )
        }
        if (j > 0) {
            findWordsImpl(board, i, j-1, nextIter, result )
        }
        if (i < board.lastIndex) {
            findWordsImpl(board, i+1, j, nextIter, result )
        }
        if (j < board.firstOrNull()?.lastIndex ?: 0) {
            findWordsImpl(board, i, j+1, nextIter, result )
        }
        board[i][j] = c
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val result = mutableListOf<String>()
        val trie = Trie().apply { add(words) }
        val m = board.lastIndex
        val n = board.firstOrNull()?.lastIndex ?: 0
        for(i in 0..m) {
            for(j in 0..n) {
                findWordsImpl(board, i, j, trie.iter(), result)
            }
        }
        return result
    }
}
fun main(args: Array<String>) {
    val board = arrayOf(charArrayOf('o','a','a','n'),charArrayOf('e','t','a','e'),charArrayOf('i','h','k','r'),charArrayOf('i','f','l','v'))
    val words = arrayOf("oath","pea","eat","rain")
    val expected = mutableListOf("eat","oath")
    expected.sort()
    val actual = Solution().findWords(board, words).toMutableList()
    actual.sort()
    println(actual)
}
