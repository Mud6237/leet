import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "1+1"
		val expected = 2
		Assert.assertEquals(expected, Solution().calculate(s))
	}
	@Test
	fun `Example 2`() {
		val s = "6-4/2"
		val expected = 4
		Assert.assertEquals(expected, Solution().calculate(s))
	}
	@Test
	fun `Example 3`() {
		val s = "2*(5+5*2)/3+(6/2+8)"
		val expected = 21
		Assert.assertEquals(expected, Solution().calculate(s))
	}
}

