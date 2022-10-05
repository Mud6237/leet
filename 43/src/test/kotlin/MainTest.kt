import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 2`() {
		val expected = "56088"
		Assert.assertEquals(expected, Solution().multiply("123", "456"))
	}

	@Test
	fun `Example 3`() {
		val expected = "81"
		Assert.assertEquals(expected, Solution().multiply("9", "9"))
	}
}

