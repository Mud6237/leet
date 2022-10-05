import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val grid = arrayOf(intArrayOf(2,1,1),intArrayOf(1,1,0),intArrayOf(0,1,1))
		val expected = 4
		Assert.assertEquals(expected, Solution().orangesRotting(grid))
	}

	@Test
	fun `Example 2`() {
		val grid = arrayOf(intArrayOf(2,1,1),intArrayOf(0,1,1),intArrayOf(1,0,1))
		val expected = -1
		Assert.assertEquals(expected, Solution().orangesRotting(grid))
	}

	@Test
	fun `Example 3`() {
		val grid = arrayOf(intArrayOf(0, 2))
		val expected = 0
		Assert.assertEquals(expected, Solution().orangesRotting(grid))
	}

	@Test
	fun `Example 4`() {
		val grid = arrayOf<IntArray>(intArrayOf())
		val expected = 0
		Assert.assertEquals(expected, Solution().orangesRotting(grid))
	}

	@Test
	fun `Example 5`() {
		val grid = arrayOf(intArrayOf(2,1,1),intArrayOf(1,1,0),intArrayOf(0,1,1))
		val expected = 4
		Assert.assertEquals(expected, Solution().orangesRotting(grid))
	}

	@Test
	fun `Example 6`() {
		val grid = arrayOf(intArrayOf(0,2))
		val expected = 0
		Assert.assertEquals(expected, Solution().orangesRotting(grid))
	}
}

