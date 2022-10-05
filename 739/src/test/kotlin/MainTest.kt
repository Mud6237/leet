import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val temperatures = intArrayOf(73,74,75,71,69,72,76,73)
		val expected = intArrayOf(1,1,4,2,1,1,0,0).toList()
		Assert.assertEquals(expected, Solution().dailyTemperatures(temperatures).toList())
	}

	@Test
	fun `Example 2`() {
		val temperatures = intArrayOf(30,40,50,60)
		val expected = intArrayOf(1,1,1,0).toList()
		Assert.assertEquals(expected, Solution().dailyTemperatures(temperatures).toList())
	}

	@Test
	fun `Example 3`() {
		val temperatures = intArrayOf(30,60,90)
		val expected = intArrayOf(1,1,0).toList()
		Assert.assertEquals(expected, Solution().dailyTemperatures(temperatures).toList())
	}
}

