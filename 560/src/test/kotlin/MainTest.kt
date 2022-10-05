import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,1,1)
		val k = 2
		val expected = 2
		Assert.assertEquals(expected, Solution().subarraySum(nums, k))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,2,3)
		val k = 3
		val expected = 2
		Assert.assertEquals(expected, Solution().subarraySum(nums, k))
	}
}

