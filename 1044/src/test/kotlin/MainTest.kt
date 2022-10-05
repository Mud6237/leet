import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "banana"
		val expected = "ana"
		Assert.assertEquals(expected, Solution().longestDupSubstring(s))
	}

	@Test
	fun `Example 2`() {
		val s = "abcd"
		val expected = ""
		Assert.assertEquals(expected, Solution().longestDupSubstring(s))
	}
}

