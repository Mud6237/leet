import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(3,1,5,8)
		val expected = 167
		Assert.assertEquals(expected, Solution().maxCoins(nums))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,3,5)
		val expected = 25
		Assert.assertEquals(expected, Solution().maxCoins(nums))
	}

	@Test
	fun `Example 3`() {
		val nums = intArrayOf(3,5,8)
		val expected = 152
		Assert.assertEquals(expected, Solution().maxCoins(nums))
	}

	@Test
	fun `Example 4`() {
		val nums = intArrayOf(1,1,1,1,1)
		val expected = 5
		Assert.assertEquals(expected, Solution().maxCoins(nums))
	}

	@Test
	fun `Example 5`() {
		val nums = intArrayOf(1,2,3,5,6)
		val expected = 150
		Assert.assertEquals(expected, Solution().maxCoins(nums))
	}

	@Test
	fun `Example 6`() {
		val nums = intArrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
		val expected = 45640
		Assert.assertEquals(expected, Solution().maxCoins(nums))
	}

	@Test
	fun `Example 7`() {
		val nums = intArrayOf(1, 5)
		val expected = 10
		Assert.assertEquals(expected, Solution().maxCoins(nums))
	}

	@Test
	fun `Example 8`() {
		val nums = intArrayOf(1, 2, 3, 4, 5)
		val expected = 110
		Assert.assertEquals(expected, Solution().maxCoins(nums))
	}
}

