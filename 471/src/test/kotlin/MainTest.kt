import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "aaa"
		val expected = "aaa"
		Assert.assertEquals(expected, Solution().encode(s))
	}
	@Test
	fun `Example 2`() {
		val s = "aaaaa"
		val expected = "5[a]"
		Assert.assertEquals(expected, Solution().encode(s))
	}
	@Test
	fun `Example 3`() {
		val s = "aaaaaaaaaa"
		val expected = "10[a]"
		Assert.assertEquals(expected, Solution().encode(s))
	}

	@Test
	fun `Example 4`() {
		val s = "aabcaabcd"
		val expected = "2[aabc]d"
		Assert.assertEquals(expected, Solution().encode(s))
	}
}

