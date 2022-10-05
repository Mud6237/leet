import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val heights = intArrayOf(2,1,5,6,2,3)
    val expected = 10
    Assert.assertEquals(expected, Solution().largestRectangleArea(heights))
  }
  @Test
  fun `Example 2`() {
    val heights = intArrayOf(2,4)
    val expected = 4
    Assert.assertEquals(expected, Solution().largestRectangleArea(heights))
  }
}