import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val grid = arrayOf(intArrayOf(1,0,0,0),intArrayOf(0,0,0,0),intArrayOf(0,0,2,-1))
		val expected = 2
		Assert.assertEquals(expected, Solution().uniquePathsIII(grid))
	}

	@Test
	fun `Example 2`() {
		val grid = arrayOf(intArrayOf(1,0,0,0),intArrayOf(0,0,0,0),intArrayOf(0,0,0,2))
		val expected = 4
		Assert.assertEquals(expected, Solution().uniquePathsIII(grid))
	}

	@Test
	fun `Example 3`() {
		val grid = arrayOf(intArrayOf(0,1),intArrayOf(2,0))
		val expected = 0
		Assert.assertEquals(expected, Solution().uniquePathsIII(grid))
	}
}

