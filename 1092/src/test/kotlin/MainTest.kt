import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val str1 = "abac"
		val str2 = "cab"
		val expected =  "cabac"
		Assert.assertEquals(expected, Solution().shortestCommonSupersequence(str1, str2))
	}

	@Test
	fun `Example 2`() {
		val str1 = "aaaaaaaa"
		val str2 = "aaaaaaaa"
		val expected =  "aaaaaaaa"
		Assert.assertEquals(expected, Solution().shortestCommonSupersequence(str1, str2))
	}

	@Test
	fun `Example 9`() {
		val str1 = "bbbaaaba"
		val str2 = "bbababbb"
		val expected =  "bbabaaababb"
		Assert.assertEquals(expected, Solution().shortestCommonSupersequence(str1, str2))
	}
}