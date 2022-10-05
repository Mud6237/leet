import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val expected = listOf(listOf(1, 2), listOf(1, 3), listOf(1, 4), listOf(2, 3), listOf(2, 4), listOf(3, 4))
		Assert.assertEquals(expected, Solution().combine(4, 2))
	}

	@Test
	fun `Example 2`() {
		val expected = listOf(listOf(1))
		Assert.assertEquals(expected, Solution().combine(1, 1))
	}

	@Test
	fun `Example 3`() {
		val expected = listOf(listOf(1))
		Assert.assertEquals(expected, Solution().combine(10, 8))
	}
}

