import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(7,2,5,10,8)
		val m = 2
		val expected = 18
		Assert.assertEquals(expected, Solution().splitArray(nums, m))
	}
	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,2,3,4,5)
		val m = 2
		val expected = 9
		Assert.assertEquals(expected, Solution().splitArray(nums, m))
	}
	@Test
	fun `Example 3`() {
		val nums = intArrayOf(1, 4, 4)
		val m = 3
		val expected = 4
		Assert.assertEquals(expected, Solution().splitArray(nums, m))
	}
	@Test
	fun `Example 4`() {
		val nums = intArrayOf(5,2,1,4,6)
		val m = 3
		val expected = 7
		Assert.assertEquals(expected, Solution().splitArray(nums, m))
	}
}

