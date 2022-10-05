import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val matrix = arrayOf(intArrayOf(1,2,3),intArrayOf(4,5,6),intArrayOf(7,8,9))
		val expected = listOf(1,2,3,6,9,8,7,4,5)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

	@Test
	fun `Example 0`() {
		val matrix = arrayOf(intArrayOf(1,2),intArrayOf(4,5))
		val expected = listOf(1,2,5,4)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

	@Test
	fun `Example 2`() {
		val matrix = arrayOf(intArrayOf(1,2,3,4),intArrayOf(5,6,7,8), intArrayOf(9,10,11,12))
		val expected = listOf(1,2,3,4,8,12,11,10,9,5,6,7)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

	@Test
	fun `Example 01`() {
		val matrix = arrayOf(intArrayOf(1,2),intArrayOf(4,5), intArrayOf(7,8))
		val expected = listOf(1,2,5,8,7,4)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

	@Test
	fun `Example 02`() {
		var i = 0
		val matrix = Array(7, { IntArray(7, { i++ }) })
		//matrix.forEach{ println(it.toList())}
		val expected = listOf(0, 1, 2, 3, 4, 5, 6, 13, 20, 27, 34, 41, 48, 47, 46, 45, 44, 43, 42, 35, 28, 21, 14, 7, 8, 9, 10, 11, 12, 19, 26, 33, 40, 39, 38, 37, 36, 29, 22, 15, 16, 17, 18, 25, 32, 31, 30, 23, 24)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

	@Test
	fun `Example 03`() {
		var i = 0
		val matrix = Array(4, { IntArray(4, { i++ }) })
		val expected = listOf(0, 1, 2, 3, 7, 11, 15, 14, 13, 12, 8, 4, 5, 6, 10, 9)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

	@Test
	fun `Example 21`() {
		val matrix = arrayOf(intArrayOf(1,2,3,4),intArrayOf(5,6,7,8),intArrayOf(9,10,11,12),intArrayOf(13,14,15,16),intArrayOf(17,18,19,20))
		val expected = listOf(1,2,3,4,8,12,16,20,19,18,17,13,9,5,6,7,11,15,14,10)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

	@Test
	fun `Example 17`() {
		val matrix = arrayOf(intArrayOf(7),intArrayOf(9),intArrayOf(6))
		val expected = listOf(7,9,6)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

	@Test
	fun `Example 04`() {
		val matrix = arrayOf(intArrayOf(7, 9, 6))
		val expected = listOf(7,9,6)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}
	
	@Test
	fun `Example 9`() {
		val matrix = arrayOf(intArrayOf(2,5,8),intArrayOf(4,0,-1))
		val expected = listOf(2,5,8,-1,0,4)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

	@Test
	fun `Example 11`() {
		val matrix = arrayOf(intArrayOf(1),intArrayOf(2),intArrayOf(3),intArrayOf(4),intArrayOf(5),intArrayOf(6),intArrayOf(7),intArrayOf(8),intArrayOf(9),intArrayOf(10))
		val expected = listOf(1,2,3,4,5,6,7,8,9,10)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

	@Test
	fun `Example 19`() {
		val matrix = arrayOf(intArrayOf(1,11),intArrayOf(2,12),intArrayOf(3,13),intArrayOf(4,14),intArrayOf(5,15),intArrayOf(6,16),intArrayOf(7,17),intArrayOf(8,18),intArrayOf(9,19),intArrayOf(10,20))
		val expected = listOf(1,11,12,13,14,15,16,17,18,19,20,10,9,8,7,6,5,4,3,2)
		Assert.assertEquals(expected, Solution().spiralOrder(matrix))
	}

}

