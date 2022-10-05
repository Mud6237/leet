import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1)
		val k = 1
		val expected = 1 
		Assert.assertEquals(expected, Solution().shortestSubarray(nums, k))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,2)
		val k = 4
		val expected = -1 
		Assert.assertEquals(expected, Solution().shortestSubarray(nums, k))
	}

	@Test
	fun `Example 3`() {
		val nums = intArrayOf(2,-1,2)
		val k = 3
		val expected = 3 
		Assert.assertEquals(expected, Solution().shortestSubarray(nums, k))
	}

	@Test
	fun `Example 57`() {
		val nums = intArrayOf(84,-37,32,40,95)
		//(   84, -37,  32,  40,  95)
		//[0, 84,  47,  79,  119, 214]
		val k = 167
		val expected = 3 
		Assert.assertEquals(expected, Solution().shortestSubarray(nums, k))
	}
}

