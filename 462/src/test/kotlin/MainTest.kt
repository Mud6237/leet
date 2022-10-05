import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,2,3)
		val expected = 2
		Assert.assertEquals(expected, Solution().minMoves2(nums))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,10,2,9)
		val expected = 16
		Assert.assertEquals(expected, Solution().minMoves2(nums))
	}
}

