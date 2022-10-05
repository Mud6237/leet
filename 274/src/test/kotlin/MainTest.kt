import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val citations = intArrayOf(3,0,6,1,5)
		val expected = 3
		Assert.assertEquals(expected, Solution().hIndex(citations))
	}

	@Test
	fun `Example 2`() {
		val citations = intArrayOf(1,3,1)
		val expected = 1
		Assert.assertEquals(expected, Solution().hIndex(citations))
	}

	@Test
	fun `Example 56`() {
		val citations = intArrayOf(100)
		val expected = 1
		Assert.assertEquals(expected, Solution().hIndex(citations))
	}

	@Test
	fun `Example 68`() {
		val citations = intArrayOf(4,4,0,0)
		val expected = 2
		Assert.assertEquals(expected, Solution().hIndex(citations))
	}
}

