import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test @Ignore
	fun `Example 1`() {
		val heights = intArrayOf(2,1,5,6,2,3)
		val expected = 10
		Assert.assertEquals(expected, Solution().largestRectangleArea(heights))
	}

	@Test
	fun `Example 2`() {
		val heights = intArrayOf(3,3,3,2,2)
		val expected = 10
		Assert.assertEquals(expected, Solution().largestRectangleArea(heights))
	}
}

