import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val expected = 10
		val s = "ABC"
		Assert.assertEquals(expected, Solution().uniqueLetterString(s))
	}

	@Test
	fun `Example 2`() {
		val expected = 8
		val s = "ABA"
		Assert.assertEquals(expected, Solution().uniqueLetterString(s))
	}

	@Test
	fun `Example 3`() {
		val expected = 92
		val s = "LEETCODE"
		Assert.assertEquals(expected, Solution().uniqueLetterString(s))
	}

	@Test
	fun `Example 4`() {
		val expected = 92
		val s = "LEETCODE"
		Assert.assertEquals(expected, Solution().uniqueLetterString(s))
	}
}

