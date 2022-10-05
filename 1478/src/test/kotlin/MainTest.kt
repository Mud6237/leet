import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val houses = intArrayOf(1,4,8,10,20)
		val k = 3
		val expected = 5
		Assert.assertEquals(expected, Solution().minDistance(houses, k))
	}

	@Test
	fun `Example 2`() {
		val houses = intArrayOf(1,4)
		val k = 1
		val expected = 3
		Assert.assertEquals(expected, Solution().minDistance(houses, k))
	}

	@Test
	fun `Example 6`() {
		val houses = intArrayOf(1,8,12,10,3)
		//val houses = intArrayOf(1,3,8,10,12)
		val k = 3
		val expected = 4
		Assert.assertEquals(expected, Solution().minDistance(houses, k))
	}
}

