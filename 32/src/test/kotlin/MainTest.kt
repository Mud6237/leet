import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val input = "(()"
		val expected = 2
		Assert.assertEquals(expected, Solution().longestValidParentheses(input))
	}
	@Test
	fun `Example 2`() {
		val input = ")()())"
		val expected = 2
		Assert.assertEquals(expected, Solution().longestValidParentheses(input))
	}

	@Test
	fun `Example 3`() {
		val input = ""
		val expected = 0
		Assert.assertEquals(expected, Solution().longestValidParentheses(input))
	}
}

