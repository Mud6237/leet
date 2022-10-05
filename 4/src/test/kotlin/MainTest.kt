import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val nums1 = intArrayOf(1,3)
    val nums2 = intArrayOf(2)
    val expected = 2.00000
    Assert.assertEquals(expected, Solution().findMedianSortedArrays(nums1, nums2),0.00001)
  }
  @Test
  fun `Example 2`() {
    val nums1 = intArrayOf(1, 2)
    val nums2 = intArrayOf(3, 4)
    val expected = 2.50000
    Assert.assertEquals(expected, Solution().findMedianSortedArrays(nums1, nums2),0.00001)
  }
  @Test
  fun `Example 3`() {
    val nums1 = intArrayOf(0,0)
    val nums2 = intArrayOf(0,0)
    val expected = 0.00000
    Assert.assertEquals(expected, Solution().findMedianSortedArrays(nums1, nums2),0.00001)
  }
  @Test
  fun `Example 4`() {
    val nums1 = intArrayOf()
    val nums2 = intArrayOf(1)
    val expected = 1.00000
    Assert.assertEquals(expected, Solution().findMedianSortedArrays(nums1, nums2),0.00001)
  }
  @Test
  fun `Example 5`() {
    val nums1 = intArrayOf(2)
    val nums2 = intArrayOf()
    val expected = 2.00000
    Assert.assertEquals(expected, Solution().findMedianSortedArrays(nums1, nums2),0.00001)
  }
}