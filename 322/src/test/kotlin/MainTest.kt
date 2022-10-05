import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val amount = 11
		val coins = intArrayOf(1,2,5)
		val expected = 3
		Assert.assertEquals(expected, Solution().coinChange(coins, amount))
	}
	@Test
	fun `Example 2`() {
		val amount = 1
		val coins = intArrayOf(2)
		val expected = -1
		Assert.assertEquals(expected, Solution().coinChange(coins, amount))
	}
	@Test
	fun `Example 180`() {
		val amount = 0
		val coins = intArrayOf(1)
		val expected = 0
		Assert.assertEquals(expected, Solution().coinChange(coins, amount))
	}
	@Test
	fun `Example 46`() {
		val amount = 6249
		val coins = intArrayOf(186,419,83,408)
		val expected = 20
		Assert.assertEquals(expected, Solution().coinChange(coins, amount))
	}

	@Test
	fun `Example 171`() {
		val amount = 0
		val coins = intArrayOf(1)
		val expected = 0
		Assert.assertEquals(expected, Solution().coinChange(coins, amount))
	}

	@Test
	fun `Example 173`() {
		val amount = 2
		val coins = intArrayOf(1,2)
		val expected = 1
		Assert.assertEquals(expected, Solution().coinChange(coins, amount))
	}
}

