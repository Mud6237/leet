import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s1 = "acb"
		val n1 = 4
		val s2 = "ab"
		val n2 = 2
		val expected = 2
		Assert.assertEquals(expected, Solution().getMaxRepetitions(s1, n1, s2, n2))
	}

	@Test
	fun `Example 2`() {
		val s1 = "acb"
		val n1 = 1
		val s2 = "acb"
		val n2 = 1
		val expected = 1
		Assert.assertEquals(expected, Solution().getMaxRepetitions(s1, n1, s2, n2))
	}

	@Test
	fun `Example 3`() {
		val s1 = "aabc"
		val n1 = 2
		val s2 = "bca"
		val n2 = 1
		val expected = 1
		Assert.assertEquals(expected, Solution().getMaxRepetitions(s1, n1, s2, n2))
	}

	@Test
	fun `Example 4`() {
		val s1 = "a"
		val n1 = 2
		val s2 = "aa"
		val n2 = 1
		val expected = 1
		Assert.assertEquals(expected, Solution().getMaxRepetitions(s1, n1, s2, n2))
	}
}

