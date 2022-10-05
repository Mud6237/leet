import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val grid = arrayOf(charArrayOf('X','X','X','X','X','X'),charArrayOf('X','*','O','O','O','X'),charArrayOf('X','O','O','#','O','X'),charArrayOf('X','X','X','X','X','X'))
		val expected = 3
		Assert.assertEquals(expected, Solution().getFood(grid))
	}
	@Test
	fun `Example 2`() {
		val grid = arrayOf(charArrayOf('X','X','X','X','X'),charArrayOf('X','*','X','O','X'),charArrayOf('X','O','X','#','X'),charArrayOf('X','X','X','X','X'))
		val expected = -1
		Assert.assertEquals(expected, Solution().getFood(grid))
	}
	@Test
	fun `Example 3`() {
		val grid = arrayOf(charArrayOf('X','X','X','X','X','X','X','X'),charArrayOf('X','*','O','X','O','#','O','X'),charArrayOf('X','O','O','X','O','O','X','X'),charArrayOf('X','O','O','O','O','#','O','X'),charArrayOf('X','X','X','X','X','X','X','X'))
		val expected = 6
		Assert.assertEquals(expected, Solution().getFood(grid))
	}
}

