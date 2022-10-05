import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(4,5,6,7,0,1,2)
		val target = 0
		val expected =  4
		Assert.assertEquals(expected, Solution().search(nums, target)) 
	}
	@Test
	fun `Example 2`() {
		val nums = intArrayOf(4,5,6,7,0,1,2)
		val target = 3
		val expected =  -1
		Assert.assertEquals(expected, Solution().search(nums, target)) 
	}
	@Test
	fun `Example 3`() {
		val nums = intArrayOf(1)
		val target = 0
		val expected =  -1
		Assert.assertEquals(expected, Solution().search(nums, target)) 
	}
	@Test
	fun `Example 4`() {
		val nums = intArrayOf(2, 3, 1)
		val target = 0
		val expected =  -1
		Assert.assertEquals(expected, Solution().search(nums, target)) 
	}

	@Test
	fun `Example 5`() {
		val nums = intArrayOf(2, 3, 4, -2, -1)
		val target = -1
		val expected = 4
		Assert.assertEquals(expected, Solution().search(nums, target)) 
	}

	@Test
	fun `Example 6`() {
		val nums = intArrayOf(2, 3, 4, -2, -1)
		val target = 2
		val expected = 0
		Assert.assertEquals(expected, Solution().search(nums, target)) 
	}

	@Test
	fun `Example 7`() {
		val nums = intArrayOf(2, 3, 4, 5, 8, 9)
		val target = 5
		val expected = 3
		Assert.assertEquals(expected, Solution().search(nums, target)) 
	}

	@Test
	fun `Example 186`() {
		val nums = intArrayOf(5,1,3)
		val target = 5
		val expected = 0
		Assert.assertEquals(expected, Solution().search(nums, target)) 
	}
}

