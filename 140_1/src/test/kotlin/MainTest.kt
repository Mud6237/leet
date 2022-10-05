import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "catsanddog"
		val wordDict = listOf("cat","cats","and","sand","dog")
		val expected = listOf("cats and dog","cat sand dog")
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}
	@Test
	fun `Example 2`() {
		val s = "pineapplepenapple"
		val wordDict = listOf("apple","pen","applepen","pine","pineapple")
		val expected = listOf("pine apple pen apple","pineapple pen apple","pine applepen apple")
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}
	@Test
	fun `Example 3`() {
		val s = "catsandog"
		val wordDict = listOf("cats","dog","sand","and","cat")
		val expected = emptyList<String>()	
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}
}

