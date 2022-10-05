import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test 
	fun `Example 1`() {
		val nums = intArrayOf(9,1,2,3,9)
		val k = 1
		val expected = 4.8
		Assert.assertEquals(expected, Solution().largestSumOfAverages(nums, k), 0.00001)
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(9,1,2,3,9)
		val k = 3
		val expected = 20.00000
		Assert.assertEquals(expected, Solution().largestSumOfAverages(nums, k), 0.00001)
	}

	@Test 
	fun `Example 3`() {
		val nums = intArrayOf(1,2,3,4,5,6,7)
		val k = 4
		val expected = 20.50000
		Assert.assertEquals(expected, Solution().largestSumOfAverages(nums, k), 0.00001)
	}

	@Test 
	fun `Example 31`() {
		val nums = intArrayOf(3324,8299,5545,6172,5817)
		val k = 2
		val expected = 11717.16667
		Assert.assertEquals(expected, Solution().largestSumOfAverages(nums, k), 0.00001)
	}
}

