import org.junit.Test
import org.junit.Ignore
import org.junit.Assert

class MainTest {
	@Test
	
	fun `Example 1`() {
		var ax1 = -3 
		var ay1 = 0 
		var ax2 = 3 
		var ay2 = 4 
		var bx1 = 0 
		var by1 = -1 
		var bx2 = 9 
		var by2 = 2
		val expected = 45
		Assert.assertEquals(expected, Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
	}

	@Test
	
	fun `Example 2`() {
		val ax1 = -2 
		val ay1 = -2 
		val ax2 = 2 
		val ay2 = 2 
		val bx1 = -2 
		val by1 = -2 
		val bx2 = 2 
		val by2 = 2
		val expected = 16
		Assert.assertEquals(expected, Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
	}

	@Test
	
	fun `Example 3`() {
		var ax1 = -3 
		var ay1 = 0 
		var ax2 = 3 
		var ay2 = 4 
		var bx1 = 0 
		var by1 = 0 
		var bx2 = 4 
		var by2 = 4
		val expected = 28
		Assert.assertEquals(expected, Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
	}

	@Test
	
	fun `Example 1773`() {
		var ax1 = -2
		var ay1 = -2
		var ax2 = 2
		var ay2 = 2
		var bx1 = -2
		var by1 = 2
		var bx2 = 2
		var by2 = 4
		val expected = 24
		Assert.assertEquals(expected, Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
	}


	@Test
	
	fun `Example 2466`() {
		var ax1 = -2
		var ay1 = -2
		var ax2 = 2
		var ay2 = 2
		var bx1 = -4
		var by1 = -2
		var bx2 = -2
		var by2 = 2
		val expected = 24
		Assert.assertEquals(expected, Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
	}

	@Test
	fun `Example 2687`() {
		var ax1 = -2
		var ay1 = -2
		var ax2 = 2
		var ay2 = 2
		var bx1 = -3
		var by1 = -3
		var bx2 = 3
		var by2 = -1
		val expected = 24
		Assert.assertEquals(expected, Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
	}

	@Test
	fun `Example 2919`() {

		var ax1 = -2
		var ay1 = -2
		var ax2 = 2
		var ay2 = 2
		var bx1 = -3
		var by1 = 1
		var bx2 = 3
		var by2 = 3
		val expected = 24
		Assert.assertEquals(expected, Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
	}

	@Test
	fun `Example 3044`() {
		var ax1 = -5
		var ay1 = -2
		var ax2 = 5
		var ay2 = 1
		var bx1 = -3
		var by1 = -3
		var bx2 = 3
		var by2 = 3
		val expected = 48
		Assert.assertEquals(expected, Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
	}

	@Test
	fun `Example 2351`() {
		var ax1 = -2
		var ay1 = -2
		var ax2 = 2
		var ay2 = 2
		var bx1 = 3
		var by1 = 3
		var bx2 = 4
		var by2 = 4
		val expected = 17
		Assert.assertEquals(expected, Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
	}

	@Test
	fun `Example 2391`() {
		var ax1 = -2
		var ay1 = -2
		var ax2 = 2
		var ay2 = 2
		var bx1 = -4
		var by1 = 3
		var bx2 = -3
		var by2 = 4
		val expected = 17
		Assert.assertEquals(expected, Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
	}
}

