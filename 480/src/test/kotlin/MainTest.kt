import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,3,-1,-3,5,3,6,7)
		val k = 3
		val expected = doubleArrayOf(1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000)
		val actual = Solution().medianSlidingWindow(nums, k)
		Assert.assertEquals(expected.toList(), actual.toList())
	}
}

