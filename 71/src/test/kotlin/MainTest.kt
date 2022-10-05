import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val path = "/home/"
		val expected = "/home"
		Assert.assertEquals(expected, Solution().simplifyPath(path))
	}

	@Test
	fun `Example 2`() {
		val path = "/../"
		val expected = "/"
		Assert.assertEquals(expected, Solution().simplifyPath(path))
	}

	@Test
	fun `Example 3`() {
		val path = "/home//foo/"
		val expected = "/home/foo"
		Assert.assertEquals(expected, Solution().simplifyPath(path))
	}
}

