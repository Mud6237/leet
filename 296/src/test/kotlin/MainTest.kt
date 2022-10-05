import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val grid = arrayOf(intArrayOf(1,0,0,0,1),intArrayOf(0,0,0,0,0),intArrayOf(0,0,1,0,0))
		val expected = 6
		Assert.assertEquals(expected, Solution().minTotalDistance(grid))
	}
}

