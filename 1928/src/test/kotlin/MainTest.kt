import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val maxTime = 30
		val edges = arrayOf(intArrayOf(0,1,10),intArrayOf(1,2,10),intArrayOf(2,5,10),intArrayOf(0,3,1),intArrayOf(3,4,10),intArrayOf(4,5,15))
		val passingFees = intArrayOf(5,1,2,20,20,3)
		val expected = 11
		Assert.assertEquals(expected, Solution().minCost(maxTime, edges, passingFees))
	}

	@Test
	fun `Example 2`() {
		val maxTime = 29
		val edges = arrayOf(intArrayOf(0,1,10),intArrayOf(1,2,10),intArrayOf(2,5,10),intArrayOf(0,3,1),intArrayOf(3,4,10),intArrayOf(4,5,15))
		val passingFees = intArrayOf(5,1,2,20,20,3)
		val expected = 48
		Assert.assertEquals(expected, Solution().minCost(maxTime, edges, passingFees))
	}

	@Test
	fun `Example 3`() {
		val maxTime = 25
		val edges = arrayOf(intArrayOf(0,1,10),intArrayOf(1,2,10),intArrayOf(2,5,10),intArrayOf(0,3,1),intArrayOf(3,4,10),intArrayOf(4,5,15))
		val passingFees = intArrayOf(5,1,2,20,20,3)
		val expected = -1
		Assert.assertEquals(expected, Solution().minCost(maxTime, edges, passingFees))
	}
}

