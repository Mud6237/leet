import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,2,3,4)
		val expected = listOf(24,12,8,6)
		Assert.assertEquals(expected, Solution().productExceptSelf(nums).toList())
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(-1,1,0,-3,3)
		val expected = listOf(0,0,9,0,0)
		Assert.assertEquals(expected, Solution().productExceptSelf(nums).toList())
	}

	@Test
	fun `Example 3`() {
		val nums = intArrayOf(-1, 2)
		val expected = listOf(2, -1)
		Assert.assertEquals(expected, Solution().productExceptSelf(nums).toList())
	}
}

