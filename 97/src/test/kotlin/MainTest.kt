import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val s1 = "aabcc"
		val s2 = "dbbca"
		val s3 = "aadbbcbcac"
		val expected = true
		Assert.assertEquals(expected, Solution().isInterleave(s1, s2, s3))
	}

	@Test
	fun `Example 2`() {
		val s1 = "aabcc"
		val s2 = "dbbca"
		val s3 = "aadbbbaccc"
		val expected = false
		Assert.assertEquals(expected, Solution().isInterleave(s1, s2, s3))
	}

	@Test
	fun `Example 3`() {
		val s1 = "a"
		val s2 = "b"
		val s3 = "ba"
		val expected = true
		Assert.assertEquals(expected, Solution().isInterleave(s1, s2, s3))
	}

	@Test
	fun `Example 96`() {
		val s1 = "aabc"
		val s2 = "abad"
		val s3 = "aabcabad"
		val expected = true
		Assert.assertEquals(expected, Solution().isInterleave(s1, s2, s3))
	}

	@Test
	fun `Example 106`() {
		val s1 ="abababababababababababababababababababababababababababababababababababababababababababababababababbb"
		val s2 ="babababababababababababababababababababababababababababababababababababababababababababababababaaaba"
		val s3 ="abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb"
		val expected = false
		Assert.assertEquals(expected, Solution().isInterleave(s1, s2, s3))
	}
}

