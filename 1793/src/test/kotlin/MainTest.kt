import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,4,3,7,4,5)
		val k = 3
		val expected = 15
		Assert.assertEquals(expected, Solution().maximumScore(nums, k))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(5,5,4,5,4,1,1,1)
		val k = 0
		val expected = 20
		Assert.assertEquals(expected, Solution().maximumScore(nums, k))
	}
}

