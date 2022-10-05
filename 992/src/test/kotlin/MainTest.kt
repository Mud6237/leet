import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,2,1,2,3)
		val k = 2
		val expected = 7
		Assert.assertEquals(expected, Solution().subarraysWithKDistinct(nums, k))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,2,1,3,4)
		val k = 3
		val expected = 3
		Assert.assertEquals(expected, Solution().subarraysWithKDistinct(nums, k))
	}
}

