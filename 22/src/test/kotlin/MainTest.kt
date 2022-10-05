import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val n = 3
		val expected = listOf("((()))","(()())","(())()","()(())","()()()")
		Assert.assertEquals(expected, Solution().generateParenthesis(n))
	}

	@Test
	fun `Example 2`() {
		val n = 6
		val expected = listOf("((()))","(()())","(())()","()(())","()()()")
		Assert.assertEquals(expected, Solution().generateParenthesis(n))
	}

	@Test
	fun `Example 3`() {
		val n = 8
		val expected = listOf("((()))","(()())","(())()","()(())","()()()")
		Assert.assertEquals(expected, Solution().generateParenthesis(n))
	}
}

