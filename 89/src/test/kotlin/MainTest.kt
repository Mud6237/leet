import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val expected = listOf(0, 1, 3, 2)
		Assert.assertEquals(expected, Solution().grayCode(2))
	}
	@Test
	fun `Example 2`() {
		val expected = listOf(0,1)
		Assert.assertEquals(expected, Solution().grayCode(1))
	}

	@Test
	fun `Example 3`() {
		val expected = listOf(0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8)
		val actual = Solution().grayCode(4)
		Assert.assertEquals(expected, actual)
	}
}

