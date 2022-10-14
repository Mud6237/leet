import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val matrix = arrayOf(intArrayOf(3, 0, 1, 4, 2), intArrayOf(5, 6, 3, 2, 1), intArrayOf(1, 2, 0, 1, 5), intArrayOf(4, 1, 0, 1, 7), intArrayOf(1, 0, 3, 0, 5))
		val numMatrix = NumMatrix(matrix)
		Assert.assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3))
		Assert.assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2))
		Assert.assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4))
	}
}

