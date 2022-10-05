import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val candidates = intArrayOf(10,1,2,7,6,1,5)
		val target = 8
		val expected = listOf(listOf(1,1,6), listOf(1,2,5), listOf(1,7), listOf(2,6))
		Assert.assertEquals(expected, Solution().combinationSum2(candidates, target))
	}

	@Test
	fun `Example 2`() {
		val candidates = intArrayOf(2,5,2,1,2)
		val target = 5
		val expected = listOf(listOf(1,2,2),listOf(5))
		Assert.assertEquals(expected, Solution().combinationSum2(candidates, target))
	}
}

