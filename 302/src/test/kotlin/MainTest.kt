import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val image = arrayOf(charArrayOf('0','0','1','0'),charArrayOf('0','1','1','0'),charArrayOf('0','1','0','0'))
		val x = 0
		val y = 2
		val expected = 6
		Assert.assertEquals(expected, Solution().minArea(image, x, y))
	}

	@Test
	fun `Example 2`() {
		val image = arrayOf(charArrayOf('1'))
		val x = 0
		val y = 0
		val expected = 1
		Assert.assertEquals(expected, Solution().minArea(image, x, y))
	}
}

