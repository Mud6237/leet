import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val grid = arrayOf(intArrayOf(1,1,0,0,0),intArrayOf(1,1,0,0,0),intArrayOf(0,0,0,1,1),intArrayOf(0,0,0,1,1))
		val expected = 1
		Assert.assertEquals(expected, Solution().numDistinctIslands(grid))
	}

	@Test
	fun `Example 2`() {
		val grid = arrayOf(intArrayOf(1,1,0,1,1),intArrayOf(1,0,0,0,0),intArrayOf(0,0,0,0,1),intArrayOf(1,1,0,1,1)) 
		val expected = 3
		Assert.assertEquals(expected, Solution().numDistinctIslands(grid))
	}
}

