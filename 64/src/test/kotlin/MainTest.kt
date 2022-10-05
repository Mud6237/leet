import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val grid = arrayOf(intArrayOf(1,3,1),intArrayOf(1,5,1),intArrayOf(4,2,1))
		val expected = 7
		Assert.assertEquals(expected, Solution().minPathSum(grid))
	}

	@Test
	fun `Example 2`() {
		val grid = arrayOf(intArrayOf(1,2,3),intArrayOf(4,5,6))
		val expected = 12
		Assert.assertEquals(expected, Solution().minPathSum(grid))
	}
}

