import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val height = intArrayOf(1,8,6,2,5,4,8,3,7)
		val expected = 49
		Assert.assertEquals(expected, Solution().maxArea(height))
	}

	@Test
	fun `Example 2`() {
		val height = intArrayOf(1,1)
		val expected = 1
		Assert.assertEquals(expected, Solution().maxArea(height))
	}
}

