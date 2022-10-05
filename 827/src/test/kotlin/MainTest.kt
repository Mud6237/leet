import org.junit.Test
import org.junit.Assert


class MainTest {
	@Test
	fun `Example 1`() {
		val grid = arrayOf(intArrayOf(1,0),intArrayOf(0,1))
		val expected = 3
		Assert.assertEquals(expected, Solution().largestIsland(grid))
	}

	@Test
	fun `Example 2`() {
		val grid = arrayOf(intArrayOf(1,1),intArrayOf(1,0))
		val expected = 4
		Assert.assertEquals(expected, Solution().largestIsland(grid))
	}

	@Test
	fun `Example 3`() {
		val grid = arrayOf(intArrayOf(1,1),intArrayOf(1,1))
		val expected = 4
		Assert.assertEquals(expected, Solution().largestIsland(grid))
	}

	@Test
	fun `Example 4`() {
		val grid = arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 0, 1), intArrayOf(0,1,0))
		val expected = 5
		Assert.assertEquals(expected, Solution().largestIsland(grid))
	}
}

