import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(1,0,0,1,0,1)
		val k = 2
		val expected = 1
		Assert.assertEquals(expected, Solution().minMoves(nums, k))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf(1,0,0,0,0,0,1,1)
		val k = 3
		val expected = 5
		Assert.assertEquals(expected, Solution().minMoves(nums, k))
	}

	@Test @Ignore
	fun `Example 3`() {
		val nums = intArrayOf(1,0,1,0,1,0,1,1,0,1,1,1)
		val k = 5
		val expected = 5
		Assert.assertEquals(expected, Solution().minMoves(nums, k))
	}
}

