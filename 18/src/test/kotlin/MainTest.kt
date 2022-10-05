import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,0,-1,0,-2,2)
		val target = 0
		val expected =  listOf(listOf(-2,-1,1,2),listOf(-2,0,0,2),listOf(-1,0,0,1))
		Assert.assertEquals(expected, Solution().fourSum(nums, target))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(2,2,2,2,2)
		val target = 8
		val expected = listOf(listOf(2,2,2,2))
		Assert.assertEquals(expected, Solution().fourSum(nums, target))
	}

	@Test
	fun `Example 167`() {
		val nums = intArrayOf(-3,-1,0,2,4,5)
		val target = 0
		val expected = listOf(listOf(-3,-1,0,4))
		Assert.assertEquals(expected, Solution().fourSum(nums, target))
	}
}

