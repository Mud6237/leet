import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val maze = arrayOf(
			intArrayOf(0,0,1,0,0),
			intArrayOf(0,0,0,0,0),
			intArrayOf(0,0,0,1,0),
			intArrayOf(1,1,0,1,1),
			intArrayOf(0,0,0,0,0)
		)
		val start = intArrayOf(0,4)
		val destination = intArrayOf(4,4)
		val expected = 12
		Assert.assertEquals(expected, Solution().shortestDistance(maze, start, destination))
	}

	@Test
	fun `Example 2`() {
		val maze = arrayOf(
			intArrayOf(0,0,1,0,0),
			intArrayOf(0,0,0,0,0),
			intArrayOf(0,0,0,1,0),
			intArrayOf(1,1,0,1,1),
			intArrayOf(0,0,0,0,0)
		)
		val start = intArrayOf(0,4)
		val destination = intArrayOf(3,2)
		val expected = -1
		Assert.assertEquals(expected, Solution().shortestDistance(maze, start, destination))
	}

	@Test
	fun `Example 3`() {
		val maze = arrayOf(
			intArrayOf(0,0,0,0,0),
			intArrayOf(1,1,0,0,1),
			intArrayOf(0,0,0,0,0),
			intArrayOf(0,1,0,0,1),
			intArrayOf(0,1,0,0,0)
		)
		val start = intArrayOf(4,3)
		val destination = intArrayOf(0,1)
		val expected = -1
		Assert.assertEquals(expected, Solution().shortestDistance(maze, start, destination))
	}
}

