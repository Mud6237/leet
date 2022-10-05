import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val data = intArrayOf(1,0,1,0,1)
		val expected = 1
		Assert.assertEquals(expected, Solution().minSwaps(data))
	}

	@Test
	fun `Example 2`() {
		val data = intArrayOf(0,0,0,1,0)
		val expected = 0
		Assert.assertEquals(expected, Solution().minSwaps(data))
	}

	@Test
	fun `Example 3`() {
		val data = intArrayOf(1,0,1,0,1,0,0,1,1,0,1)
		val expected = 3
		Assert.assertEquals(expected, Solution().minSwaps(data))
	}
}

