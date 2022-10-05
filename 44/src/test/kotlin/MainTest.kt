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
		val p = "*"
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
}

