import org.junit.Test
import org.junit.Assert


class MainTest {
    @Test
    fun `Example 1`() {
        val words = arrayOf("cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat")
        val expected = listOf("catsdogcats","dogcatsdog","ratcatdogcat")
        Assert.assertEquals(Solution().findAllConcatenatdWordsInDict(words), expected)
    }
    @Test
    fun `Example 2`() {
        val words = arrayOf("cat","dog","catdog")
        val expected = listOf("catdog")
        Assert.assertEquals(Solution().findAllConcatenatdWordsInDict(words), expected)
    }   
}