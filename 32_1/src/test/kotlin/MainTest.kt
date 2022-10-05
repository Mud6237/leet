import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "(()"
		val expected = 2
		Assert.assertEquals(expected, Solution().longestValidParentheses(s))
	}

	@Test
	fun `Example 2`() {
		val s = ")()())"
		val expected = 4
		Assert.assertEquals(expected, Solution().longestValidParentheses(s))
	}

	@Test
	fun `Example 56`() {
		val s = "()"
		val expected = 2
		Assert.assertEquals(expected, Solution().longestValidParentheses(s))
	}

	@Test
	fun `Example 73`() {
		val s = "()(())"
		val expected = 6
		Assert.assertEquals(expected, Solution().longestValidParentheses(s))
	}
}

