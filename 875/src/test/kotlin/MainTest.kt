import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val piles = intArrayOf(3,6,7,11)
		val h = 8
		val expected = 4
		Assert.assertEquals(expected, Solution().minEatingSpeed(piles, h))
	}

	@Test
	fun `Example 2`() {
		val piles = intArrayOf(30,11,23,4,20)
		val h = 5
		val expected = 30
		Assert.assertEquals(expected, Solution().minEatingSpeed(piles, h))
	}

	@Test
	fun `Example 3`() {
		val piles = intArrayOf(30,11,23,4,20)
		val h = 6
		val expected = 23
		Assert.assertEquals(expected, Solution().minEatingSpeed(piles, h))
	}
}

