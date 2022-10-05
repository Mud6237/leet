import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val n = 4
		val expected = listOf(listOf(".Q..","...Q","Q...","..Q."),listOf("..Q.","Q...","...Q",".Q.."))
		Assert.assertEquals(expected, Solution().solveNQueens(n))
	}

	@Test
	fun `Example 2`() {
		val n = 1
		val expected = listOf(listOf("Q"))
		Assert.assertEquals(expected, Solution().solveNQueens(n))
	}
}

