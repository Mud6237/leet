import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val gas = intArrayOf(1,2,3,4,5)
		val cost = intArrayOf(3,4,5,1,2)
		val expected =  3
		Assert.assertEquals(expected, Solution().canCompleteCircuit(gas, cost))
	}

	@Test
	fun `Example 31`() {
		val gas = intArrayOf(5,8,2,8)
		val cost = intArrayOf(6,5,6,6)
		val expected =  3
		Assert.assertEquals(expected, Solution().canCompleteCircuit(gas, cost))
	}
}

