import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val s = "catsanddog"
    val wordDict = listOf("cat","cats","and","sand","dog")
    val expected =  mutableListOf("cats and dog","cat sand dog")
    val actual = Solution().wordBreak(s, wordDict).toMutableList()
    expected.sort()
    actual.sort()
    Assert.assertEquals(expected, actual)
  }
  @Test
  fun `Example 2`() {
    val s = "pineapplepenapple"
    val wordDict = listOf("apple","pen","applepen","pine","pineapple")
    val expected = mutableListOf("pine apple pen apple","pineapple pen apple","pine applepen apple")
    val actual = Solution().wordBreak(s, wordDict).toMutableList()
    expected.sort()
    actual.sort()
    Assert.assertEquals(expected, actual)
  }
  @Test
  fun `Example 3`() {
    val s = "catsandog"
    val wordDict = listOf("cats","dog","sand","and","cat")
    val expected = emptyList<String>()
    val actual = Solution().wordBreak(s, wordDict)
    Assert.assertEquals(expected, actual)
  }
}