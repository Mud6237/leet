
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val board = arrayOf(charArrayOf('A','B','C','E'),charArrayOf('S','F','C','S'),charArrayOf('A','D','E','E'))
		val word = "ABCCED"
		val expected = true
		Assert.assertEquals(expected, Solution().exist(board, word))
	}

	@Test
	fun `Example 2`() {
		val board = arrayOf(charArrayOf('A','B','C','E'),charArrayOf('S','F','C','S'),charArrayOf('A','D','E','E'))
		val word = "SEE"
		val expected = true
		Assert.assertEquals(expected, Solution().exist(board, word))
	}

	@Test
	fun `Example 3`() {
		val board = arrayOf(charArrayOf('A','B','C','E'),charArrayOf('S','F','C','S'),charArrayOf('A','D','E','E'))
		val word = "ABCB"
		val expected = false
		Assert.assertEquals(expected, Solution().exist(board, word))
	}
	@Test
	fun `Example 4`() {
		val board = arrayOf(charArrayOf('A'))
		val word = "A"
		val expected = true
		Assert.assertEquals(expected, Solution().exist(board, word))
	}

	@Test
	fun `Example 75`() {
		val board = arrayOf(charArrayOf('a', 'a'))
		val word = "aaa"
		val expected = false
		Assert.assertEquals(expected, Solution().exist(board, word))
	}
}

