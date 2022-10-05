import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val stones = intArrayOf(0,1,3,5,6,8,12,17)
		val expected = true
		Assert.assertEquals(expected, Solution().canCross(stones))
	}

	@Test
	fun `Example 2`() {
		val stones = intArrayOf(0,1,2,3,4,8,9,11)
		val expected = false
		Assert.assertEquals(expected, Solution().canCross(stones))
	}
}

