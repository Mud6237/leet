import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1, 2)
		val expected = 1
		Assert.assertEquals(expected, Solution().maxScore(nums))
	}
	@Test
	fun `Example 2`() {
		val nums = intArrayOf(3, 4, 6, 8)
		val expected = 11
		Assert.assertEquals(expected, Solution().maxScore(nums))
	}
	@Test
	fun `Example 3`() {
		val nums = intArrayOf(1, 2, 3, 4, 5, 6)
		val expected = 14
		Assert.assertEquals(expected, Solution().maxScore(nums))
	}
}

