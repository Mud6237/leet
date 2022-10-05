import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test @Ignore
	fun `Example 1`() {
		val grid = arrayOf(intArrayOf(0,1,1),intArrayOf(1,1,0),intArrayOf(1,1,0))
		val expected = 2
		Assert.assertEquals(expected, Solution().minimumObstacles(grid))
	}

	@Test
	fun `Example 2`() {
		val grid = arrayOf(
			intArrayOf(0,1,0,0,0),
			intArrayOf(0,1,0,1,0),
			intArrayOf(0,0,0,1,0)
		)
		val expected = 0
		Assert.assertEquals(expected, Solution().minimumObstacles(grid))
	}
}

