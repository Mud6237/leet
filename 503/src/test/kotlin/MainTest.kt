import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,2,1)
		val expected = listOf(2,-1,2)
		Assert.assertEquals(expected, Solution().nextGreaterElements(nums).toList())
	}
	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,2,3,4,3)
		val expected = listOf(2,3,4,-1,4)
		Assert.assertEquals(expected, Solution().nextGreaterElements(nums).toList())
	}
	@Test
	fun `Example 3`() {
		val nums = intArrayOf(1,2,3,4,1, 2)
		val expected = listOf(2,3,4,-1,2,3)
		Assert.assertEquals(expected, Solution().nextGreaterElements(nums).toList())
	}
}

