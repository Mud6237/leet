import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s1 = "ab"
		val s2 = "ba"
		val expected = 1
		Assert.assertEquals(expected, Solution().kSimilarity(s1, s2))
	}
	@Test
	fun `Example 2`() {
		val s1 = "abc"
		val s2 = "bca"
		val expected = 2
		Assert.assertEquals(expected, Solution().kSimilarity(s1, s2))
	}
	@Test
	fun `Example 3`() {
		val s1 = "abc"
		val s2 = "bac"
		val expected = 1
		Assert.assertEquals(expected, Solution().kSimilarity(s1, s2))
	}
	@Test
	fun `Example 4`() {
		val s1 = "abc"
		val s2 = "abc"
		val expected = 0
		Assert.assertEquals(expected, Solution().kSimilarity(s1, s2))
	}
}

