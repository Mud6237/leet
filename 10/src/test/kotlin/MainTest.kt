import org.junit.Test
import org.junit.Assert

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
		val p = "a*"
		val expected = true
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}
	
	@Test
	fun `Example 3`() {
		val s = "ab"
		val p = ".*"
		val expected = true
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}

	@Test
	fun `Example 4`() {
		val s = ""
		val p = "a+"
		val expected = false
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}

	@Test
	fun `Example 5`() {
		val s = ""
		val p = ".*"
		val expected = true
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}

	@Test
	fun `Example 6`() {
		val s = "abbba"
		val p = "a(bb)+.*"
		val expected = true
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}
	
	@Test
	fun `Example 6`() {
		val s = "abbba"
		val p = "a(bb)+.*"
		val expected = true
		Assert.assertEquals(expected, Solution().isMatch(s, p))
	}
}

