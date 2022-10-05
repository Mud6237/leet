import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val words = arrayOf("alex","loves","leetcode")
		val expected = "leetcodelovesalex"
		Assert.assertEquals(expected, Solution().shortestSuperstring(words))
	}
	@Test
	fun `Example 2`() {
		val words = arrayOf("catg","ctaagt","gcta","ttca","atgcatc")
		val expected = "gctaagttcatgcatc"
		Assert.assertEquals(expected, Solution().shortestSuperstring(words))
	}
}
