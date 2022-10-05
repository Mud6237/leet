import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val num = 3
		val expected = "III"
		Assert.assertEquals(expected, Solution().intToRoman(num))
	}

	@Test
	fun `Example 2`() {
		val num = 58
		val expected = "LVIII"
		Assert.assertEquals(expected, Solution().intToRoman(num))
	}

	@Test
	fun `Example 3`() {
		val num = 1994
		val expected = "MCMXCIV"
		Assert.assertEquals(expected, Solution().intToRoman(num))
	}
}

