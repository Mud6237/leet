import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val k = 3
		val n = 7
		val expected = listOf(listOf(1,2,4))
		Assert.assertEquals(expected, Solution().combinationSum3(k, n))
	}
	@Test
	fun `Example 2`() {
		val k = 4
		val n = 1
		val expected = listOf<List<Int>>()
		Assert.assertEquals(expected, Solution().combinationSum3(k, n))
	}
}

