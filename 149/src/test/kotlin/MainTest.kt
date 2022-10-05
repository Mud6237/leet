import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val points = arrayOf(intArrayOf(1,1),intArrayOf(2,2),intArrayOf(3,3))
		val expected = 3
		Assert.assertEquals(expected, Solution().maxPoints(points))
	}

	@Test
	fun `Example 2`() {
		val points = arrayOf(intArrayOf(1,1),intArrayOf(3,2),intArrayOf(5,3),intArrayOf(4,1),intArrayOf(2,3),intArrayOf(1,4))
		val expected = 4
		Assert.assertEquals(expected, Solution().maxPoints(points))
	}
}

