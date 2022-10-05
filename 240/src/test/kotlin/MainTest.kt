import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val matrix = arrayOf(intArrayOf(1,4,7,11,15),intArrayOf(2,5,8,12,19),intArrayOf(3,6,9,16,22),intArrayOf(10,13,14,17,24),intArrayOf(18,21,23,26,30))
		val target = 5
		val expected = true
		Assert.assertEquals(expected, Solution().searchMatrix(matrix, target))
	}

	@Test
	fun `Example 2`() {
		val matrix = arrayOf(intArrayOf(1,4,7,11,15),intArrayOf(2,5,8,12,19),intArrayOf(3,6,9,16,22),intArrayOf(10,13,14,17,24),intArrayOf(18,21,23,26,30))
		val target = 20
		val expected = false
		Assert.assertEquals(expected, Solution().searchMatrix(matrix, target))
	}
}

