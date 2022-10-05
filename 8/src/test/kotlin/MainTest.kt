import org.junit.Test
import org.junit.Ignore
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val expected = Int.MAX_VALUE
		Assert.assertEquals(expected, Solution().myAtoi("2147483648"))
	}

	@Test
	fun `Example 2`() {
		val expected = Int.MIN_VALUE
		Assert.assertEquals(expected, Solution().myAtoi("-2147483648"))
	}
	
	@Test
	fun `Example 3`() {
		val expected = Int.MIN_VALUE
		Assert.assertEquals(expected, Solution().myAtoi("-2147483649"))
	}

	@Test
	fun `Example 4`() {
		val expected = 42
		Assert.assertEquals(expected, Solution().myAtoi("42"))
	}

	@Test
	fun `Example 5`() {
		val expected = -42
		Assert.assertEquals(expected, Solution().myAtoi("   -42"))
	}

	@Test
	fun `Example 6`() {
		val expected = 4193
		Assert.assertEquals(expected, Solution().myAtoi("4193 with words"))
	}

	@Test
	fun `Example 7`() {
		val expected = 0
		Assert.assertEquals(expected, Solution().myAtoi("----1231"))
	}
	
	@Test
	fun `Example 8`() {
		val expected = -9120
		Assert.assertEquals(expected, Solution().myAtoi("  -9120-123"))
	}
	@Test
	fun `Example 9`() {
		val expected = 1
		Assert.assertEquals(expected, Solution().myAtoi("  +1"))
	}
}

