import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val wordDict =  WordDictionary()
		wordDict.addWord("bad")
		wordDict.addWord("dad")
		wordDict.addWord("baddy")
		wordDict.addWord("bod")
		wordDict.addWord("bp")
		Assert.assertEquals(true, wordDict.search("bad"))
		Assert.assertEquals(true, wordDict.search("dad"))
		Assert.assertEquals(true, wordDict.search("b.d"))
		Assert.assertEquals(false, wordDict.search("bp."))
	}
}

