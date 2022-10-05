import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val password = "a"
		val expected = 5
		Assert.assertEquals(expected, Solution().strongPasswordChecker(password))
	}

	@Test
	fun `Example 2`() {
		val password = "aA1"
		val expected = 3
		Assert.assertEquals(expected, Solution().strongPasswordChecker(password))
	}

	@Test
	fun `Example 3`() {
		val password = "1337C0d3"
		val expected = 0
		Assert.assertEquals(expected, Solution().strongPasswordChecker(password))
	}

	@Test
	fun `Example 4`() {
		val password = "aaaaaabcaaa12aaaefghi"
		val expected = 4
		Assert.assertEquals(expected, Solution().strongPasswordChecker(password))
	}

	@Test
	fun `Example 31`() {
		val password = "aaaB1"
		val expected = 1
		Assert.assertEquals(expected, Solution().strongPasswordChecker(password))
	}

	@Test
	fun `Example 36`() {
		val password = "1111111111"
		val expected = 3
		Assert.assertEquals(expected, Solution().strongPasswordChecker(password))
	}
	
	@Test
	fun `Example 41`() {
		val password = "bbaaaaaaaaaaaaaaacccccc"
		val expected = 8
		Assert.assertEquals(expected, Solution().strongPasswordChecker(password))
	}

	@Test
	fun `Example 42`() {
		val password = "ABABABABABABABABABAB1"
		val expected = 2
		Assert.assertEquals(expected, Solution().strongPasswordChecker(password))
	}
}