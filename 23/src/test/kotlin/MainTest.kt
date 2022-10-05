import org.junit.Test
import org.junit.Assert

class MainTest {
  @Test
  fun `Example 1`() {
    val inputList = arrayOf( Solution.makeList(listOf(1,4,5)), Solution.makeList(listOf(1,3,4)), Solution.makeList(listOf(2,6)))
    val expected = Solution.makeList(listOf(1,1,2,3,4,4,5,6))
    Assert.assertEquals(expected, Solution().mergeKLists(inputList))
  }
}