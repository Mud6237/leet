import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val words = arrayOf("wrt","wrf","er","ett","rftt")
    val expected = "wertf"
    val actual = Solution().alienOrder(words)
    Assert.assertEquals(expected, actual)
  }
  @Test
  fun `Example 2`() {
    val words = arrayOf("z","x")
    val expected = "zx"
    val actual = Solution().alienOrder(words)
    Assert.assertEquals(expected, actual)
  }
  @Test
  fun `Example 3`() {
    val words = arrayOf("z","x","z")
    val expected = ""
    val actual = Solution().alienOrder(words)
    Assert.assertEquals(expected, actual)
  }
}