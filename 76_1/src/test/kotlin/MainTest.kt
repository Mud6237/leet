import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "ADOBECODEBANC"
		val t = "ABC"
		val expected = "BANC"
		Assert.assertEquals(expected, Solution().minWindow(s, t))
	}

	@Test
	fun `Example 2`() {
		val s = "ADOBECODEBANC"
		val t = "ZAK"
		val expected = ""
		Assert.assertEquals(expected, Solution().minWindow(s, t))
	}

	@Test
	fun `Example 3`() {
		val s = "ABAACBAB"
		val t = "ABC"
		val expected = "ACB"
		Assert.assertEquals(expected, Solution().minWindow(s, t))
	}

	@Test
	fun `Example 4`() {
		val s = "CBAA"
		val t = "ABC"
		val expected = "CBA"
		Assert.assertEquals(expected, Solution().minWindow(s, t))
	}

	@Test
	fun `Example 5`() {
		val s = "a"
		val t = "a"
		val expected = "a"
		Assert.assertEquals(expected, Solution().minWindow(s, t))
	}

	@Test
	fun `Example 6`() {
		val s = "a"
		val t = "aa"
		val expected = ""
		Assert.assertEquals(expected, Solution().minWindow(s, t))
	}
}

