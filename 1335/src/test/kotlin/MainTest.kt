import org.junit.Test
import org.junit.Assert

class MainTest {
    @Test
    fun `Example 1`() {
        val input = intArrayOf(6,5,4,3,2,1)
        val d = 2
        Assert.assertEquals(Solution().minDifficulty(input, d), 7)
    }
    @Test
    fun `Example 2`() {
        val input = intArrayOf(9,9,9)
        val d = 4
        Assert.assertEquals(Solution().minDifficulty(input, d), -1)
    }
    @Test
    fun `Example 3`() {
        val input = intArrayOf(1,1,1)
        val d = 3
        Assert.assertEquals(Solution().minDifficulty(input, d), 3)
    }
    @Test
    fun `test case 4`() {
        val input = intArrayOf(7,1,7,1,7,1)
        val d = 3
        Assert.assertEquals(Solution().minDifficulty(input, d), 15)
    }

    @Test
    fun `Example 5`() {
        val input = intArrayOf(11,111,22,222,33,333,44,444)
        val d = 6
        Assert.assertEquals(Solution().minDifficulty(input, d), 843)
    }
}