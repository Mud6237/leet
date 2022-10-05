import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val expected = 3
		Assert.assertEquals(expected, Solution().lengthOfLongestSubstring("abcabcbb"))
	}

	@Test
	fun `Example 2`() {
		val expected = 1
		Assert.assertEquals(expected, Solution().lengthOfLongestSubstring("bbbbb"))
	}

	@Test
	fun `Example 3`() {
		val expected = 3
		Assert.assertEquals(expected, Solution().lengthOfLongestSubstring("pwwkew"))
	}

	@Test
	fun `Example 4`() {
		val expected = 5
		Assert.assertEquals(expected, Solution().lengthOfLongestSubstring("pwwkewrc"))
	}

	@Test
	fun `Example 5`() {
		val expected = 3
		Assert.assertEquals(expected, Solution().lengthOfLongestSubstring("kewew"))
	}

	@Test
	fun `Example 6`() {
		val expected = 1
		Assert.assertEquals(expected, Solution().lengthOfLongestSubstring(" "))
	}

	@Test
	fun `Example 317`() {
		val expected = 2
		Assert.assertEquals(expected, Solution().lengthOfLongestSubstring("aab"))
	}
}

