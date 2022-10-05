import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1, 2, 3)
		val expected = emptyList<List<Int>>()
		Assert.assertEquals(expected, Solution().subsets(nums))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1, 2, 3,4,5,6,7,8,9,10)
		val expected = emptyList<List<Int>>()
		Assert.assertEquals(expected, Solution().subsets(nums))
	}

	@Test
	fun `Example 3`() {
		val nums = intArrayOf(1)
		val expected = emptyList<List<Int>>()
		Assert.assertEquals(expected, Solution().subsets(nums))
	}
}

