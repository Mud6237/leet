import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,3)
		val n = 6
		val expected = 1
		Assert.assertEquals(expected, Solution().minPatches(nums, n))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,5,10)
		val n = 20
		val expected = 2
		Assert.assertEquals(expected, Solution().minPatches(nums, n))
	}

	@Test
	fun `Example 3`() {
		val nums = intArrayOf(1,2,2)
		val n = 5
		val expected = 0
		Assert.assertEquals(expected, Solution().minPatches(nums, n))
	}

	@Test
	fun `Example 4`() {
		val nums = intArrayOf(1,5,10)
		val n = 20
		val expected = 2
		Assert.assertEquals(expected, Solution().minPatches(nums, n))
	}

	@Test
	fun `Example 5`() {
		val nums = intArrayOf(1, 2, 4, 13, 43)
		val n = 100
		val expected = 2
		Assert.assertEquals(expected, Solution().minPatches(nums, n))
	}
	
	@Test
	fun `Example 102`() {
		val nums = intArrayOf(1,2,31,33)
		val n = 2147483647
		val expected = 28
		Assert.assertEquals(expected, Solution().minPatches(nums, n))
	}

}

