import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "zzazz"
		val expected = 0
		Assert.assertEquals(expected, Solution().minInsertions(s))
	}
	@Test
	fun `Example 2`() {
		val s = "mbadm"
		val expected = 2
		Assert.assertEquals(expected, Solution().minInsertions(s))
	}
	@Test
	fun `Example 3`() {
		val s = "leetcode"
		val expected = 5
		Assert.assertEquals(expected, Solution().minInsertions(s))
	}
}

