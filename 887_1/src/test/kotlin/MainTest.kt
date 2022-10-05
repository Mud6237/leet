import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val k = 1
		val n = 2
		val expected =  2
		Assert.assertEquals(expected, Solution().superEggDrop(k, n))
	}

	@Test
	fun `Example 2`() {
		val k = 2
		val n = 6
		val expected =  3
		Assert.assertEquals(expected, Solution().superEggDrop(k, n))
	}

	@Test
	fun `Example 3`() {
		val k = 3
		val n = 14
		val expected =  4
		Assert.assertEquals(expected, Solution().superEggDrop(k, n))
	}

	@Test
	fun `Example 45`() {
		val k = 3
		val n = 2
		val expected =  2
		Assert.assertEquals(expected, Solution().superEggDrop(k, n))
	}

	@Test
	fun `Example 47`() {
		val k = 3
		val n = 4
		val expected =  3
		Assert.assertEquals(expected, Solution().superEggDrop(k, n))
	}

	@Test
	fun `Example 89`() {
		val k = 9
		val n = 10000
		val expected =  14
		Assert.assertEquals(expected, Solution().superEggDrop(k, n))
	}
}

