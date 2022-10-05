import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val arr = intArrayOf(3,1,2,4)
		val expected = 17
		Assert.assertEquals(expected, Solution().sumSubarrayMins(arr))
	}
	@Test
	fun `Example 2`() {
		val arr = intArrayOf(11,81,94,43,3)
		// 11 = 1
		// 11, 81 = 92
		// 11, 81, 94 = 186
		// 11, 43, 43, 43 = 140
		// 3, 3, 3, 3, 3 = 15
		val expected = 444
		Assert.assertEquals(expected, Solution().sumSubarrayMins(arr))
	}
	
	@Test
	fun `Example 31`() {
		val arr = intArrayOf(19,19,62,66)
		// 19 = 19
		// 19, 19 = 38
		// 19, 19, 62 = 100
		// 19, 19, 62, 66 = 166
		val expected = 323
		Assert.assertEquals(expected, Solution().sumSubarrayMins(arr))
	}

	@Test
	fun `Example 32`() {
		val arr = intArrayOf(26,23,65,36,19,51,4,11,99,20)
		// 26 = 26
		// 23, 23 = 46 = 72
		// 23, 23, 65 = 111 = 183
		// 23, 23, 36, 36 = 118 = 301
		// 19, 19, 19, 19, 19 = 95 = 396
		// 19, 19, 19, 19, 19, 51 = 146 = 542
		// 4, 4, 4, 4, 4, 4, 4, = 28 = 570
		// 4, 4, 4, 4, 4, 4, 4, 11 = 39 = 609
		// 4, 4, 4, 4, 4, 4, 4, 11, 99 = 138 = 747 
		// 4, 4, 4, 4, 4, 4, 4, 11, 20, 20 = 79 = 826
		val expected = 826
		Assert.assertEquals(expected, Solution().sumSubarrayMins(arr))
	}
}

