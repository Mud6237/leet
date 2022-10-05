import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(3,9,7,3)
		val expected = 2
		Assert.assertEquals(expected, Solution().minimumDifference(nums))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(-36,36)
		val expected = 72
		Assert.assertEquals(expected, Solution().minimumDifference(nums))
	}

	@Test
	fun `Example 3`() {
		val nums = intArrayOf(2,-1,0,4,-2,-9)
		val expected = 0
		Assert.assertEquals(expected, Solution().minimumDifference(nums))
	}

	@Test
	fun `Example 19`() {
		val nums = intArrayOf(0,6,11,17,18,24)
		val expected = 6
		Assert.assertEquals(expected, Solution().minimumDifference(nums))
	}

	@Test
	fun `Example 134`() {
		val nums = intArrayOf(7772197,4460211,-7641449,-8856364,546755,-3673029,527497,-9392076,3130315,-5309187,-4781283,5919119,3093450,1132720,6380128,-3954678,-1651499,-7944388,-3056827,1610628,7711173,6595873,302974,7656726,-2572679,0,2121026,-5743797,-8897395,-9699694)
		val expected = 1
		Assert.assertEquals(expected, Solution().minimumDifference(nums))
	}
}

