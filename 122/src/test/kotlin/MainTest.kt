import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val prices = intArrayOf(7,1,5,3,6,4)
		val expected =  7
		Assert.assertEquals(expected, Solution().maxProfit(prices))
	}
	@Test
	fun `Example 2`() {
		val prices = intArrayOf(1,2,3,4,5)
		val expected =  4
		Assert.assertEquals(expected, Solution().maxProfit(prices))
	}
	@Test
	fun `Example 3`() {
		val prices = intArrayOf(7,6,4,3,1)
		val expected =  0
		Assert.assertEquals(expected, Solution().maxProfit(prices))
	}
}

