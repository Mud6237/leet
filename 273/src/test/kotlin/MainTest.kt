import org.junit.Test
import org.junit.Assert

class MainTest {
    @Test
    fun `Example 1`() {
        val expected = "One Hundred Twenty Three"
        Assert.assertEquals(expected, Solution().numberToWords(123))
    }
    @Test
    fun `Example 2`() {
        val expected = "Twelve Thousand Three Hundred Forty Five"
        Assert.assertEquals(expected, Solution().numberToWords(12345))
    }
    @Test
    fun `Example 3`() {
        val expected = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        Assert.assertEquals(expected, Solution().numberToWords(1234567))
    }
    @Test
    fun `Example 4`() {
        val expected = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
        Assert.assertEquals(expected, Solution().numberToWords(1234567891))
    }
}