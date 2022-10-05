import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val expected = 2
		Assert.assertEquals(expected, Solution().superEggDrop(1, 2))
	}
	@Test
	fun `Example 2`() {
		val expected = 3
		Assert.assertEquals(expected, Solution().superEggDrop(2, 6))
	}
	@Test
	fun `Example 3`() {
		val expected = 4
		Assert.assertEquals(expected, Solution().superEggDrop(3, 14))
	}
}

