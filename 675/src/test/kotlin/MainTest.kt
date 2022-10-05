import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val forest = listOf(listOf(1,2,3),listOf(0,0,4),listOf(7,6,5))
    val expected = 6
    
    Assert.assertEquals(expected, Solution().cutOffTree(forest))
  }

  @Test
  fun `Example 2`() {
    val forest = listOf(listOf(1,2,3),listOf(0,0,0),listOf(7,6,5))
    val expected = -1
    Assert.assertEquals(expected, Solution().cutOffTree(forest))
  }

  @Test
  fun `Example 3`() {
    val forest = listOf(listOf(2,3,4),listOf(0,0,5),listOf(8,7,6))
    val expected = 6
    Assert.assertEquals(expected, Solution().cutOffTree(forest))
  }

}