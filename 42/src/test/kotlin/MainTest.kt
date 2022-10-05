import org.junit.Test
import org.junit.Assert

class MainTest {
  
  @Test
  fun `Example 1`() {
   val height = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
   Assert.assertEquals(Solution().trap(height), 6)
  }

  @Test
  fun `Example 2`() {
    val height = intArrayOf(4,2,0,3,2,5)
    Assert.assertEquals(Solution().trap(height), 9)
  }
}