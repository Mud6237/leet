import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val n = 5
		val expected = 2
		Assert.assertEquals(expected, Solution().consecutiveNumbersSum(n))
	}
	@Test
	fun `Example 2`() {
		val n = 9
		val expected = 3
		Assert.assertEquals(expected, Solution().consecutiveNumbersSum(n))
	}
	@Test
	fun `Example 3`() {
		val n = 15
		val expected = 4
		Assert.assertEquals(expected, Solution().consecutiveNumbersSum(n))
	}
}

