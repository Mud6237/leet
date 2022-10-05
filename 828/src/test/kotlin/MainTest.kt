import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val s = "ABC"
    val expected = 10
    Assert.assertEquals(expected, Solution().uniqueLetterString(s))
  }
  @Test
  fun `Example 2`() {
    val s = "ABA"
    val expected = 8
    Assert.assertEquals(expected, Solution().uniqueLetterString(s))
  }
  @Test
  fun `Example 3`() {
    val s = "LEETCODE"
    val expected = 92
    Assert.assertEquals(expected, Solution().uniqueLetterString(s))
  }
}