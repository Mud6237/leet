import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,2,0)
		val expected = 3
		Assert.assertEquals(expected, Solution().firstMissingPositive(nums))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(3,4,-1,1)
		val expected = 2
		Assert.assertEquals(expected, Solution().firstMissingPositive(nums))
	}

	@Test
	fun `Example 3`() {
		val nums = intArrayOf(3,4,-1,1)
		val expected = 2
		Assert.assertEquals(expected, Solution().firstMissingPositive(nums))
	}
}

