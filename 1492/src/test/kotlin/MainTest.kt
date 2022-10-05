import org.junit.Test
import org.junit.Ignore
import org.junit.Assert

class MainTest {
	@Test @Ignore
	fun `Example 1`() {
		val n = 12
		val k = 3
		val expected = 3
		Assert.assertEquals(expected, Solution().kthFactor(n, k))
	}

	@Test @Ignore
	fun `Example 2`() {
		val n = 7
		val k = 2
		val expected = 7
		Assert.assertEquals(expected, Solution().kthFactor(n, k))
	}

	@Test @Ignore
	fun `Example 3`() {
		val n = 4
		val k = 4
		val expected = -1
		Assert.assertEquals(expected, Solution().kthFactor(n, k))
	}

	@Test @Ignore
	fun `Example 4`() {
		val n = 1
		val k = 1
		val expected = 1
		Assert.assertEquals(expected, Solution().kthFactor(n, k))
	}
	@Test @Ignore
	fun `Example 5`() {
		val n = 19
		val k = 4
		val expected = -1
		Assert.assertEquals(expected, Solution().kthFactor(n, k))
	}

	@Test
	fun `Example 144`() {
		val n = 24
		val k = 6
		val expected = 8
		Assert.assertEquals(expected, Solution().kthFactor(n, k))
	}
}

