import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "00110011"
		val expected = 6
		Assert.assertEquals(expected, Solution().countBinarySubstrings(s))
	}

	@Test
	fun `Example 2`() {
		val s = "10101"
		val expected = 4
		Assert.assertEquals(expected, Solution().countBinarySubstrings(s))
	}
}

