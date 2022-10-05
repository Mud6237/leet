import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val board = arrayOf(
			charArrayOf('5','3','.','.','7','.','.','.','.'),
			charArrayOf('6','.','.','1','9','5','.','.','.'),
			charArrayOf('.','9','8','.','.','.','.','6','.'),
			charArrayOf('8','.','.','.','6','.','.','.','3'),
			charArrayOf('4','.','.','8','.','3','.','.','1'),
			charArrayOf('7','.','.','.','2','.','.','.','6'),
			charArrayOf('.','6','.','.','.','.','2','8','.'),
			charArrayOf('.','.','.','4','1','9','.','.','5'),
			charArrayOf('.','.','.','.','8','.','.','7','9')
		)
		val expected = true
		Assert.assertEquals(expected, Solution().isValidSudoku(board))
	}

	@Test
	fun `Example 2`() {
		val board = arrayOf(
			charArrayOf('8','3','.','.','7','.','.','.','.'),
			charArrayOf('6','.','.','1','9','5','.','.','.'),
			charArrayOf('.','9','8','.','.','.','.','6','.'),
			charArrayOf('8','.','.','.','6','.','.','.','3'),
			charArrayOf('4','.','.','8','.','3','.','.','1'),
			charArrayOf('7','.','.','.','2','.','.','.','6'),
			charArrayOf('.','6','.','.','.','.','2','8','.'),
			charArrayOf('.','.','.','4','1','9','.','.','5'),
			charArrayOf('.','.','.','.','8','.','.','7','9')
		)
		val expected = false
		Assert.assertEquals(expected, Solution().isValidSudoku(board))
	}
}

