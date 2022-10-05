import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val board = arrayOf(charArrayOf('5','3','.','.','7','.','.','.','.'),charArrayOf('6','.','.','1','9','5','.','.','.'),charArrayOf('.','9','8','.','.','.','.','6','.'),charArrayOf('8','.','.','.','6','.','.','.','3'),charArrayOf('4','.','.','8','.','3','.','.','1'),charArrayOf('7','.','.','.','2','.','.','.','6'),charArrayOf('.','6','.','.','.','.','2','8','.'),charArrayOf('.','.','.','4','1','9','.','.','5'),charArrayOf('.','.','.','.','8','.','.','7','9'))
		val expected =  arrayOf(charArrayOf('5','3','4','6','7','8','9','1','2'),charArrayOf('6','7','2','1','9','5','3','4','8'),charArrayOf('1','9','8','3','4','2','5','6','7'),charArrayOf('8','5','9','7','6','1','4','2','3'),charArrayOf('4','2','6','8','5','3','7','9','1'),charArrayOf('7','1','3','9','2','4','8','5','6'),charArrayOf('9','6','1','5','3','7','2','8','4'),charArrayOf('2','8','7','4','1','9','6','3','5'),charArrayOf('3','4','5','2','8','6','1','7','9'))

		val expectedSb = StringBuilder()
		expected.forEach{ expectedSb.append(it.toList().joinToString("")) }
		
		Solution().solveSudoku(board)
		val actualSb = StringBuilder()
		board.forEach{ actualSb.append(it.toList().joinToString("")) }

		Assert.assertEquals(expectedSb.toString(), actualSb.toString())
	}
}

