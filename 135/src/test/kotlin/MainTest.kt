import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		var ratings = intArrayOf(1,0,2)
		val expected = 5
		Assert.assertEquals(expected, Solution().candy(ratings))
	}
	@Test
	fun `Example 2`() {
		var ratings = intArrayOf(1,2,2)
		val expected = 4
		Assert.assertEquals(expected, Solution().candy(ratings))
	}
	@Test
	fun `Example 3`() {
		var ratings = intArrayOf(12,4,3,11,34,34,1,67)
		val expected = 16
		Assert.assertEquals(expected, Solution().candy(ratings))
	}
}

