import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val word1 = "horse"
		val word2 = "ros"
		val expected = 3
		Assert.assertEquals(expected, Solution().minDistance(word1, word2))
	}
	@Test
	fun `Example 2`() {
		val word1 = "intention"
		val word2 = "execution"
		val expected = 5
		Assert.assertEquals(expected, Solution().minDistance(word1, word2))
	}
}

