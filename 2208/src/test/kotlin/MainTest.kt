import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(5,19,8,1)
		val expected = 3
		Assert.assertEquals(expected, Solution().halveArray(nums))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(3,8,20)
		val expected = 3
		Assert.assertEquals(expected, Solution().halveArray(nums))
	}
}

