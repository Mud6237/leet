import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val k = 2
		val prices = intArrayOf(2, 4, 1)
		val expected = 2
		Assert.assertEquals(expected, Solution().maxProfit(k, prices))
	}

	@Test
	fun `Example 2`() {
		val k = 2
		val prices = intArrayOf(3,2,6,5,0,3)
		val expected = 7
		Assert.assertEquals(expected, Solution().maxProfit(k, prices))
	}
}

