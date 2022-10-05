import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test 
	fun `Example 1`() {
		val nums = intArrayOf(1,-2,-3,4)
		val expected = 4
		Assert.assertEquals(expected, Solution().getMaxLen(nums))
	}

	@Test 
	fun `Example 2`() {
		val nums = intArrayOf(0,1,-2,-3,-4)
		val expected = 3
		Assert.assertEquals(expected, Solution().getMaxLen(nums))
	}

	@Test 
	fun `Example 3`() {
		val nums = intArrayOf(-1,-2,-3,0,1)
		val expected = 2
		Assert.assertEquals(expected, Solution().getMaxLen(nums))
	}

	@Test
	fun `Example 78`() {
		val nums = intArrayOf(5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2)
		val expected = 8
		Assert.assertEquals(expected, Solution().getMaxLen(nums))
	}
}

