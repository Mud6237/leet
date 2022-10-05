import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s1 = "abcdebdde"
		val s2 = "bde"
		val expected =  "bcde"
		Assert.assertEquals(expected, Solution().minWindow(s1, s2))
	}
	@Test
	fun `Example 2`() {
		val s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl"
		val s2 = "u"
		val expected =  ""
		Assert.assertEquals(expected, Solution().minWindow(s1, s2))
	}
}

