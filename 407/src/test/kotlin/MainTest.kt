import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val heightMap = arrayOf(intArrayOf(1,4,3,1,3,2),intArrayOf(3,2,1,3,2,4),intArrayOf(2,3,3,2,3,1))
		val expected = 4
		Assert.assertEquals(expected, Solution().trapRainWater(heightMap))
	}
	@Test
	fun `Example 2`() {
		val heightMap = arrayOf(intArrayOf(3,3,3,3,3),intArrayOf(3,2,2,2,3),intArrayOf(3,2,1,2,3),intArrayOf(3,2,2,2,3),intArrayOf(3,3,3,3,3))
		val expected = 10
		Assert.assertEquals(expected, Solution().trapRainWater(heightMap))
	}
}

