import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val moves = arrayOf(intArrayOf(0,0),intArrayOf(2,0),intArrayOf(1,1),intArrayOf(2,1),intArrayOf(2,2))
		val expected = "A"
		Assert.assertEquals(expected, Solution().tictactoe(moves))
	}

	@Test
	fun `Example 2`() {
		val moves = arrayOf(intArrayOf(0,0),intArrayOf(1,1),intArrayOf(0,1),intArrayOf(0,2),intArrayOf(1,0),intArrayOf(2,0))
		val expected = "B"
		Assert.assertEquals(expected, Solution().tictactoe(moves))
	}

	@Test
	fun `Example 3`() {
		val moves = arrayOf(intArrayOf(0,0),intArrayOf(1,1),intArrayOf(2,0),intArrayOf(1,0),intArrayOf(1,2),intArrayOf(2,1),intArrayOf(0,1),intArrayOf(0,2),intArrayOf(2,2))
		val expected = "Draw"
		Assert.assertEquals(expected, Solution().tictactoe(moves))
	}
}

