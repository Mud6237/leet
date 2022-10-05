import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,2,3)
		val expected = 4L
		Assert.assertEquals(expected, Solution().subArrayRanges(nums))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,3,3)
		val expected = 4L
		Assert.assertEquals(expected, Solution().subArrayRanges(nums))
	}
	@Test
	fun `Example 3`() {
		val nums = intArrayOf(4, -2, -3, 4, 1)
		val expected = 59L
		Assert.assertEquals(expected, Solution().subArrayRanges(nums))
	}
}

