import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "aa"
		val p = "a"
		val expected = false
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}
	
	@Test
	fun `Example 2`() {
		val s = "aa"
		val p = "*aa"
		val expected = true
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}

	@Test
	fun `Example 3`() {
		val s = "cb"
		val p = "?a"
		val expected = false
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}

	@Test
	fun `Example 17`() {
		val s = "zacabz"
		val p = "*a?b*"
		val expected = false
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}

	@Test
	fun `Example 943`() {
		val s = "abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb"
		val p = "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"
		val expected = true
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}

	@Test
	fun `Example 4`() {
		val s = "abc"
		val p = "a**"
		val expected = true
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}
}

