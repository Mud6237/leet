import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "leetcode"
		val wordDict = listOf("leet","code")
		val expected= true
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}
	@Test
	fun `Example 2`() {
		val s = "applepenapple"
		val wordDict = listOf("apple","pen")
		val expected= true
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}

	@Test
	fun `Example 3`() {
		val s = "catsandog"
		val wordDict = listOf("cats","dog","sand","and","cat")
		val expected= false
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}

	@Test
	fun `Example 35`() {
		val s = "catsandogcat"
		val wordDict = listOf("cats","dog","sand","and","cat", "an")
		val expected= true
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}

	@Test
	fun `Example 33`() {
		val s = "aaaaaaa"
		val wordDict = listOf("aaaa","aaa")
		val expected = true
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}

	@Test
	fun `Example 34`() {
		val s = "aebbbbs"
		val wordDict = listOf("a","aeb", "ebbbb", "s", "eb")
		val expected = true
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}

	@Test
	fun `Example 32`() {
		val s = "aaaaaaaa"
		val wordDict = listOf("aaaa","aa", "a")
		val expected = true
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}

	@Test
	fun `Example 23`() {
		val s = "dogs"
		val wordDict = listOf("dog","s", "gs")
		val expected = true
		Assert.assertEquals(expected, Solution().wordBreak(s, wordDict))
	}
}

