import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val n = 1
		val a = 2
		val b = 3
		val expected = 2
		Assert.assertEquals(expected, Solution().nthMagicalNumber(n, a, b))
	}

	@Test
	fun `Example 2`() {
		val n = 4
		val a = 2
		val b = 3
		val expected = 6
		Assert.assertEquals(expected, Solution().nthMagicalNumber(n, a, b))
	}
}

