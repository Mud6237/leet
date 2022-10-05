import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(3,2,1,5,6,4)
		val k = 2
		val expected = 5
		Assert.assertEquals(expected, Solution().findKthLargest(nums, k))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(3,2,3,1,2,4,5,5,6)
		val k = 4
		val expected = 4
		Assert.assertEquals(expected, Solution().findKthLargest(nums, k))
	}
}

