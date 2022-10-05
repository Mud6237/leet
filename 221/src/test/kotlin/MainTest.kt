import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val matrix = arrayOf(charArrayOf('1','0','1','0','0'),charArrayOf('1','0','1','1','1'),charArrayOf('1','1','1','1','1'),charArrayOf('1','0','0','1','0'))
		val expected = 4
		Assert.assertEquals(expected, Solution().maximalSquare(matrix))
	}

	@Test
	fun `Example 2`() {
		val matrix = arrayOf(charArrayOf('0','1'),charArrayOf('1','0'))
		val expected = 1
		Assert.assertEquals(expected, Solution().maximalSquare(matrix))
	}

	@Test
	fun `Example 3`() {
		val matrix = arrayOf(charArrayOf('0'))
		val expected = 0
		Assert.assertEquals(expected, Solution().maximalSquare(matrix))
	}

	@Test
	fun `Example 58`() {
		val matrix = arrayOf(charArrayOf('1','0','1','0'),charArrayOf('1','0','1','1'),charArrayOf('1','0','1','1'),charArrayOf('1','1','1','1'))
		val expected = 4
		Assert.assertEquals(expected, Solution().maximalSquare(matrix))
	}

	@Test
	fun `Example 38`() {
		val matrix = arrayOf(charArrayOf('1','0'),charArrayOf('0','0'))
		val expected = 1
		Assert.assertEquals(expected, Solution().maximalSquare(matrix))
	}
}

