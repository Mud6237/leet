import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(2,1,3,4)
		val expected = 6
		Assert.assertEquals(expected, Solution().sumSubseqWidths(nums))
	}
}

