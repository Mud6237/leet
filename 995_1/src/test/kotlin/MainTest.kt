import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(0,1,0)
		val k = 1
		val expected = 2
		Assert.assertEquals(expected, Solution().minKBitFlips(nums, k))
	}
	
	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,1,0)
		val k = 2
		val expected = -1
		Assert.assertEquals(expected, Solution().minKBitFlips(nums, k))
	}

	@Test
	fun `Example 3`() {
		val nums = intArrayOf(0,0,0,1,0,1,1,0)
		val k = 3
		val expected = 3
		Assert.assertEquals(expected, Solution().minKBitFlips(nums, k))
	}
}

