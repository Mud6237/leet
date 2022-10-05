import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val points = arrayOf(intArrayOf(1,3),intArrayOf(-2,2))
		val k = 1
		val expected = listOf(listOf(-2, 2))
		val actual = Solution().kClosest(points, k).toList().map { it.toList() }
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 2`() {
		val points = arrayOf(intArrayOf(3,3),intArrayOf(5,-1),intArrayOf(-2,4))
		val k = 2
		val expected = listOf(listOf(3,3), listOf(-2,4))
		val actual = Solution().kClosest(points, k).toList().map { it.toList() }
		Assert.assertEquals(expected, actual)
	}
	
	@Test
	fun `Example 3`() {
		val points = arrayOf<IntArray>()
		val k = 0
		val expected = listOf<List<Int>>()
		val actual = Solution().kClosest(points, k).toList().map { it.toList() }
		Assert.assertEquals(expected, actual)
	
	}
	@Test
	fun `Example 4`() {
		val points = arrayOf<IntArray>(intArrayOf(9, 0))
		val k = 1
		val expected = listOf<List<Int>>(listOf(9, 0))
		val actual = Solution().kClosest(points, k).toList().map { it.toList() }
		Assert.assertEquals(expected, actual)
	}
}

