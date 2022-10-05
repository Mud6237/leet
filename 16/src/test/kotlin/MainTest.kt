import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(-1,2,1,-4)
		val target = 1
		val expected = 2
		Assert.assertEquals(expected, Solution().threeSumClosest(nums, target))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(0,0,0)
		val target = 1
		val expected = 0
		Assert.assertEquals(expected, Solution().threeSumClosest(nums, target))
	}

	@Test
	fun `Example 125`() {
		val nums = intArrayOf(-1,0,1,1,55)
		val target = 3
		val expected = 2
		Assert.assertEquals(expected, Solution().threeSumClosest(nums, target))
	}
}

