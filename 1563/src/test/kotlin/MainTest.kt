import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val stoneValue = intArrayOf(6,2,3,4,5,5)
		val expected = 18
		Assert.assertEquals(expected, Solution().stoneGameV(stoneValue))
	}

	@Test
	fun `Example 2`() {
		val stoneValue =intArrayOf(7,7,7,7,7,7,7)
		val expected = 28
		Assert.assertEquals(expected, Solution().stoneGameV(stoneValue))
	}

	@Test
	fun `Example 3`() {
		val stoneValue = intArrayOf(4)
		val expected = 0
		Assert.assertEquals(expected, Solution().stoneGameV(stoneValue))
	}
}

