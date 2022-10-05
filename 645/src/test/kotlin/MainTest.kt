import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val nums = intArrayOf(1,2,2,4)
    val expected = listOf(2,3)
    Assert.assertEquals(expected, Solution().findErrorNums(nums).toList())
  }
}