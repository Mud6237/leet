import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val board = arrayOf(charArrayOf('o','a','a','n'),charArrayOf('e','t','a','e'),charArrayOf('i','h','k','r'),charArrayOf('i','f','l','v'))
    val words = arrayOf("oath","pea","eat","rain")
    val expected = mutableListOf("eat"," o  ath")
    expected.sort()
    val actual = Solution().findWords(board, words).toMutableList()
    actual.sort()
    Assert.assertEquals(expected, actual)
  }

  @Test
  fun `Example 2`() {
    val board = arrayOf(charArrayOf('a','b'),charArrayOf('c','d'))
    val words = arrayOf("abcd")
    val expected = mutableListOf<String>()
    expected.sort()
    val actual = Solution().findWords(board, words).toMutableList()
    actual.sort()
    Assert.assertEquals(expected, actual)
  }


}