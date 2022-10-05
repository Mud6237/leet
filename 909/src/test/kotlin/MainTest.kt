import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 0`() {
		Assert.assertEquals(
			Pair(4,0),
			Solution.numToIndex(1, 5)
		)
		Assert.assertEquals(
			Pair(3,1),
			Solution.numToIndex(9, 5)
		)
		Assert.assertEquals(
			Pair(3,0),
			Solution.numToIndex(10, 5)
		)
		Assert.assertEquals(
			Pair(2,0),
			Solution.numToIndex(11, 5)
		)
		Assert.assertEquals(
			Pair(0,4),
			Solution.numToIndex(25, 5)
		)
	}
	@Test
	fun `Example 1`() {
		val board = arrayOf(intArrayOf(-1,-1,-1,-1,-1,-1),intArrayOf(-1,-1,-1,-1,-1,-1),intArrayOf(-1,-1,-1,-1,-1,-1),intArrayOf(-1,35,-1,-1,13,-1),intArrayOf(-1,-1,-1,-1,-1,-1),intArrayOf(-1,15,-1,-1,-1,-1))
		val expected = 4
		Assert.assertEquals(expected, Solution().snakesAndLadders(board))
	}

	@Test
	fun `Example 2`() {
		val board = arrayOf(intArrayOf(-1,-1),intArrayOf(-1,3))
		val expected = 1
		Assert.assertEquals(expected, Solution().snakesAndLadders(board))
	}

	@Test
	fun `Example 204`() {
		val board = arrayOf(
			intArrayOf(-1,-1,-1,46,47,-1,-1,-1),
			intArrayOf(51,-1,-1,63,-1,31,21,-1),
			intArrayOf(-1,-1,26,-1,-1,38,-1,-1),
			intArrayOf(-1,-1,11,-1,14,23,56,57),
			intArrayOf(11,-1,-1,-1,49,36,-1,48),
			intArrayOf(-1,-1,-1,33,56,-1,57,21),
			intArrayOf(-1,-1,-1,-1,-1,-1,2,-1),
			intArrayOf(-1,-1,-1,8,3,-1,6,56)
		)
		val expected = 4
		Assert.assertEquals(expected, Solution().snakesAndLadders(board))
	}

	@Test
	fun `Example 207`() {
		val board = arrayOf(intArrayOf(-1,-1,-1,30,-1,144,124,135,-1,-1,-1,-1,-1),intArrayOf(-1,-1,-1,-1,-1,-1,167,93,-1,-1,-1,-1,-1),intArrayOf(-1,-1,-1,-1,-1,-1,-1,77,-1,-1,90,-1,-1),intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1),intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122,-1),intArrayOf(-1,-1,-1,23,-1,-1,-1,-1,-1,155,-1,-1,-1),intArrayOf(-1,-1,140,29,-1,-1,-1,-1,-1,-1,-1,-1,-1),intArrayOf(-1,-1,-1,-1,-1,115,-1,-1,-1,109,-1,-1,5),intArrayOf(-1,57,-1,99,121,-1,-1,132,-1,-1,-1,-1,-1),intArrayOf(-1,48,-1,-1,-1,68,-1,-1,-1,-1,31,-1,-1),intArrayOf(-1,163,147,-1,77,-1,-1,114,-1,-1,80,-1,-1),intArrayOf(-1,-1,-1,-1,-1,57,28,-1,-1,129,-1,-1,-1),intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,87,-1,-1,-1))
		val expected = 6
		Assert.assertEquals(expected, Solution().snakesAndLadders(board))
	}
}

