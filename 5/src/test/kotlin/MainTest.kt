import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "babad"
		val expected = "bab"
		Assert.assertEquals(expected, Solution().longestPalindrome(s))
	}

	@Test
	fun `Example 2`() {
		val s = "cbbd"
		val expected = "bb"
		Assert.assertEquals(expected, Solution().longestPalindrome(s))
	}

	@Test
	fun `Example 3`() {
		val s = "bbbbbbb"
		val expected = "bbbbbbb"
		Assert.assertEquals(expected, Solution().longestPalindrome(s))
	}
}

