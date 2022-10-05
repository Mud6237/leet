import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val expected = 21
		Assert.assertEquals(expected, Solution().countDigitOne(100))
	}
}

