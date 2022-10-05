import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val matrix = arrayOf(intArrayOf(9,9,4),intArrayOf(6,6,8),intArrayOf(2,1,1))
		val expected = 4
		Assert.assertEquals(expected, Solution().longestIncreasingPath(matrix))
	}
	@Test
	fun `Example 2`() {
		val matrix = arrayOf(intArrayOf(3,4,5),intArrayOf(3,2,6),intArrayOf(2,2,1))
		val expected = 4
		Assert.assertEquals(expected, Solution().longestIncreasingPath(matrix))
	}
	@Test
	fun `Example 3`() {
		val matrix = arrayOf(intArrayOf(1))
		val expected = 1
		Assert.assertEquals(expected, Solution().longestIncreasingPath(matrix))
	}
	@Test
	fun `Example 4`() {
		val matrix = arrayOf(intArrayOf(1, 2))
		val expected = 2
		Assert.assertEquals(expected, Solution().longestIncreasingPath(matrix))
	}
	@Test
	fun `Example 5`() {
		val matrix = arrayOf(intArrayOf(7,8,9),intArrayOf(9,7,6),intArrayOf(7,2,3))
		val expected = 6
		Assert.assertEquals(expected, Solution().longestIncreasingPath(matrix))
	}
	@Test
	fun `Example 6`() {
		val matrix= arrayOf(intArrayOf(15,19,1,1,19,0,3,2,4,2,6,10,16,18,8),intArrayOf(16,11,0,13,19,12,2,14,13,6,5,14,19,5,16),intArrayOf(18,7,8,17,7,2,8,0,12,14,18,5,16,19,0),intArrayOf(18,9,14,5,3,7,14,0,3,16,17,10,4,4,8),intArrayOf(11,6,2,7,0,5,1,16,7,14,9,10,6,17,2),intArrayOf(2,5,8,8,5,10,15,14,1,6,15,12,19,10,13),intArrayOf(7,10,5,18,4,11,1,17,14,8,6,2,10,19,6),intArrayOf(9,16,11,15,14,7,18,0,4,6,0,15,15,14,11),intArrayOf(12,5,9,8,2,18,9,13,14,5,18,2,13,15,14),intArrayOf(7,4,5,7,19,0,6,15,16,16,6,7,18,2,8),intArrayOf(6,17,10,3,10,15,10,4,17,15,11,7,9,13,13),intArrayOf(15,6,8,14,10,18,14,13,9,19,19,15,6,17,7),intArrayOf(15,8,7,6,14,16,16,15,2,2,7,0,0,14,8),intArrayOf(14,2,1,10,17,6,3,1,0,1,7,1,11,15,4),intArrayOf(17,1,16,4,11,8,14,19,13,15,9,1,17,12,13),intArrayOf(15,18,17,11,12,14,18,14,13,16,8,17,5,15,12),intArrayOf(18,15,18,18,18,16,4,9,0,8,16,1,5,5,9),intArrayOf(8,2,16,7,13,0,13,13,11,4,15,8,19,12,1),intArrayOf(6,6,2,7,17,10,16,16,19,3,10,4,9,6,11))
		val expected = 10
		Assert.assertEquals(expected, Solution().longestIncreasingPath(matrix))
	}
	
}

