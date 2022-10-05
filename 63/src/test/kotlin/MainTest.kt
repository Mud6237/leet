import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val obstacleGrid = arrayOf(intArrayOf(0,0,0),intArrayOf(0,1,0),intArrayOf(0,0,0))
		val expected = 2
		Assert.assertEquals(expected, Solution().uniquePathsWithObstacles(obstacleGrid))
	}
	@Test
	fun `Example 2`() {
		val obstacleGrid = arrayOf(intArrayOf(0,1),intArrayOf(0,0))
		val expected = 1
		Assert.assertEquals(expected, Solution().uniquePathsWithObstacles(obstacleGrid))
	}
}

