import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val candidates = intArrayOf(2,3,6,7)
		val target = 7
		val expected = listOf(listOf(2,2,3),listOf(7))
		Assert.assertEquals(expected, Solution().combinationSum(candidates, target))
	}

	@Test
	fun `Example 2`() {
		val candidates = intArrayOf(2,3,5)
		val target = 8
		val expected = listOf(listOf(2,2,2,2),listOf(2,3,3),listOf(3,5))
		Assert.assertEquals(expected, Solution().combinationSum(candidates, target))
	}

	@Test
	fun `Example 3`() {
		val candidates = intArrayOf(2)
		val target = 1
		val expected = listOf<List<Int>>()
		Assert.assertEquals(expected, Solution().combinationSum(candidates, target))
	}

	@Test
	fun `Example 166`() {
		val candidates = intArrayOf(7,3,6,5)
		val target = 7
		val expected = listOf<List<Int>>(listOf(7))
		Assert.assertEquals(expected, Solution().combinationSum(candidates, target))
	}

	@Test
	fun `Example 167`() {
		val candidates = intArrayOf(7,3,9,6)
		val target = 6
		val expected = listOf(listOf(3,3), listOf(6))
		Assert.assertEquals(expected, Solution().combinationSum(candidates, target))
	}
}

