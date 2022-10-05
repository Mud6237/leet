import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test @Ignore
	fun `Example 1`() {
		val nums = intArrayOf(1,2,2)
		val expected = listOf(listOf(), listOf(1), listOf(2), listOf(1, 2), listOf(2, 2), listOf(1, 2, 2))
		Assert.assertEquals(expected, Solution().subsetsWithDup(nums))
	}

	@Test @Ignore
	fun `Example 2`() {
		val nums = intArrayOf(0)
		val expected =listOf(listOf(),listOf(0))
		Assert.assertEquals(expected, Solution().subsetsWithDup(nums))
	}
	@Test @Ignore
	fun `Example 3`() {
		val nums = intArrayOf(0,1,3)
		val expected = listOf(listOf(), listOf(0), listOf(1), listOf(3), listOf(0, 1), listOf(0, 3), listOf(1, 3), listOf(0, 1, 3))
		Assert.assertEquals(expected, Solution().subsetsWithDup(nums))
	}

	@Test @Ignore
	fun `Example 4`() {
		val nums = intArrayOf(0,1,2,3,4,5,6,7,8,9)
		val expected = listOf(listOf<Int>())
		Assert.assertEquals(expected, Solution().subsetsWithDup(nums))
	}

	@Test
	fun `Example 16`() {
		val nums = intArrayOf(1,1,2,2)
		val expected = listOf(listOf<Int>())
		Assert.assertEquals(expected, Solution().subsetsWithDup(nums))
	}
}

