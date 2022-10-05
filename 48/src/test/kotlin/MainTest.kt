import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 00`() {
		var i = 0
		val matrix = Array(4, { IntArray(4, { i++ }) })
		Solution().rotate(matrix)
		val expected = listOf(listOf(12, 8, 4, 0), listOf(13, 9, 5, 1), listOf(14, 10, 6, 2), listOf(15, 11, 7, 3))
		val actual = matrix.map { it.toList() }
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 01`() {
		var i = 0
		val matrix = Array(2, { IntArray(2, { i++ }) })
		Solution().rotate(matrix)
		val expected = listOf(listOf(2, 0), listOf(3, 1))
		val actual = matrix.map { it.toList() }
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 02`() {
		var i = 0
		val matrix = Array(1, { IntArray(1, { i++ }) })
		Solution().rotate(matrix)
		val expected = listOf(listOf(0))
		val actual = matrix.map { it.toList() }
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 03`() {
		var i = 0
		val matrix = Array(7, { IntArray(7, { i++ }) })
		Solution().rotate(matrix)
		val expected = listOf(listOf(42, 35, 28, 21, 14, 7, 0),
									listOf(43, 36, 29, 22, 15, 8, 1),
									listOf(44, 37, 30, 23, 16, 9, 2),
									listOf(45, 38, 31, 24, 17, 10, 3),
									listOf(46, 39, 32, 25, 18, 11, 4),
									listOf(47, 40, 33, 26, 19, 12, 5),
									listOf(48, 41, 34, 27, 20, 13, 6))

		val actual = matrix.map { it.toList() }
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 0`() {
		val matrix = arrayOf(intArrayOf(1,2,3),intArrayOf(4,5,6),intArrayOf(7,8,9))
		Solution().rotate(matrix)
		val expected = listOf(listOf(7,4,1),listOf(8,5,2),listOf(9,6,3))
		val actual = matrix.map { it.toList() }
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 1`() {
		val matrix = arrayOf(intArrayOf(5,1,9,11),intArrayOf(2,4,8,10),intArrayOf(13,3,6,7),intArrayOf(15,14,12,16))
		Solution().rotate(matrix)
		val expected = listOf(listOf(15,13,2,5),listOf(14,3,4,1),listOf(12,6,8,9),listOf(16,7,10,11))
		val actual = matrix.map { it.toList() }
		Assert.assertEquals(expected, actual)
	}
}

