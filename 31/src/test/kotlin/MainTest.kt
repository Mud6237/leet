import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,2,3)
		val expected = intArrayOf(1,3,2).toList()
		Solution().nextPermutation(nums)
		Assert.assertEquals(expected, nums.toList())
	}
	@Test
	fun `Example 2`() {
		val nums = intArrayOf(2,3,2,0)
		val expected = intArrayOf(3,0,2,2).toList()
		Solution().nextPermutation(nums)
		Assert.assertEquals(expected, nums.toList())
	}

	@Test
	fun `Example 3`() {
		val nums = intArrayOf(4,2,0,2,3,2,0)
		val expected = intArrayOf(4,2,0,3,0,2,2).toList()
		Solution().nextPermutation(nums)
		Assert.assertEquals(expected, nums.toList())
	}

	@Test
	fun `Example 201`() {
		val nums = intArrayOf(1,3,2)
		val expected = intArrayOf(2,1,3).toList()
		Solution().nextPermutation(nums)
		Assert.assertEquals(expected, nums.toList())
	}
}

