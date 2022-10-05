import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val s = "ADOBECODEBANC"
    val t = "ABC"
    val expected = "BANC"
    Assert.assertEquals(expected, Solution().minWindow(s, t))
  }

  @Test
  fun `Example 2`() {
    val s = "a"
    val t = "a"
    val expected = "a"
    Assert.assertEquals(expected, Solution().minWindow(s, t))
  }

  @Test
  fun `Example 3`() {
    val s = "a"
    val t = "aa"
    val expected = ""
    Assert.assertEquals(expected, Solution().minWindow(s, t))
  }
}