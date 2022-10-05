import org.junit.Test
import org.junit.Ignore
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "catsanddog"
		val wordDict = listOf("cat","cats","and","sand","dog")
		val expected = listOf("cat sand dog", "cats and dog",)
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}
	
	@Test
	fun `Example 2`() {
		val s = "pineapplepenapple"
		val wordDict = listOf("apple","pen","applepen","pine","pineapple")
		val expected = listOf("pine apple pen apple","pine applepen apple","pineapple pen apple")
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

