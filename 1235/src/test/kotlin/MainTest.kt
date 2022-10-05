import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val startTime = intArrayOf(1,2,3,3)
		val endTime = intArrayOf(3,4,5,6)
		val profit = intArrayOf(50,10,40,70)
		val expected = 120
		Assert.assertEquals(expected, Solution().jobScheduling(startTime, endTime, profit))
	}

	@Test
	fun `Example 2`() {
		val startTime = intArrayOf(1,2,3,4,6)
		val endTime = intArrayOf(3,5,10,6,9)
		val profit = intArrayOf(20,20,100,70,60)
		val expected = 150
		Assert.assertEquals(expected, Solution().jobScheduling(startTime, endTime, profit))
	}

	@Test
	fun `Example 3`() {
		val startTime = intArrayOf(1,1,1)
		val endTime = intArrayOf(2,3,4)
		val profit = intArrayOf(5,6,4)
		val expected = 6
		Assert.assertEquals(expected, Solution().jobScheduling(startTime, endTime, profit))
	}

	@Test
	fun `Example 8`() {
		val startTime = intArrayOf(6,15,7,11,1,3,16,2)
		val endTime = intArrayOf(19,18,19,16,10,8,19,8)
		val profit = intArrayOf(2,9,1,19,5,7,3,19)
		val expected = 41
		Assert.assertEquals(expected, Solution().jobScheduling(startTime, endTime, profit))
	}

	@Test
	fun `Example 29`() {
		val startTime = intArrayOf(4,3,1,2,4,8,3,3,3,9)
		val endTime = intArrayOf(5,6,3,5,9,9,8,5,7,10)
		val profit = intArrayOf(9,9,5,12,10,11,10,4,14,7)
		val expected = 37
		Assert.assertEquals(expected, Solution().jobScheduling(startTime, endTime, profit))
	}
}

