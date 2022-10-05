import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val sticks = intArrayOf(2, 4, 3)
		val expected = 14
		Assert.assertEquals(expected, Solution().connectSticks(sticks))
	}
	@Test
	fun `Example 2`() {
		val sticks = intArrayOf(1, 8, 3, 5)
		val expected = 30
		Assert.assertEquals(expected, Solution().connectSticks(sticks))
	}

	@Test
	fun `Example 3`() {
		val sticks = intArrayOf(5)
		val expected = 0
		Assert.assertEquals(expected, Solution().connectSticks(sticks))
	}
}

