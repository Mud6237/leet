import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val board = arrayOf(charArrayOf('o','a','a','n'),charArrayOf('e','t','a','e'),charArrayOf('i','h','k','r'),charArrayOf('i','f','l','v'))
		val words = arrayOf("oath","pea","eat","rain")
		val expected = listOf("eat","oath")
		Assert.assertEquals(expected, Solution().findWords(board, words))
	}
	@Test
	fun `Example 2`() {
		val board = arrayOf(charArrayOf('a','b'),charArrayOf('c','d'))
		val words = arrayOf("abcb")
		val expected = listOf<String>()
		Assert.assertEquals(expected, Solution().findWords(board, words))
	}
}

