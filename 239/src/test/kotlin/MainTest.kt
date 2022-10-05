import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val nums = intArrayOf(1,3,-1,-3,5,3,6,7)
    val k = 3
    val expected = intArrayOf(3,3,5,5,6,7).toList()
    val actual = Solution().maxSlidingWindow(nums, k).toList()
    Assert.assertEquals(expected, actual)
  }

  @Test
  fun `Example 2`() {
    val nums = intArrayOf(1)
    val k = 1
    val expected = intArrayOf(1).toList()
    val actual = Solution().maxSlidingWindow(nums, k).toList()
    Assert.assertEquals(expected, actual)
  }

  @Test
  fun `Example 3`() {
    val nums = intArrayOf(1, -1)
    val k = 1
    val expected = intArrayOf(1, -1).toList()
    val actual = Solution().maxSlidingWindow(nums, k).toList()
    Assert.assertEquals(expected, actual)
  }

  @Test
  fun `Example 4`() {
    val nums = intArrayOf(9, 11)
    val k = 2
    val expected = intArrayOf(11).toList()
    val actual = Solution().maxSlidingWindow(nums, k).toList()
    Assert.assertEquals(expected, actual)
  }

  @Test
  fun `Example 5`() {
    val nums = intArrayOf(4, -2)
    val k = 2
    val expected = intArrayOf(4).toList()
    val actual = Solution().maxSlidingWindow(nums, k).toList()
    Assert.assertEquals(expected, actual)
  }
}