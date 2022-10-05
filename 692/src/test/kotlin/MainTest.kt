import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val words = arrayOf("i","love","leetcode","i","love","coding")
		val k = 2
		val expected = arrayOf("i","love").toList()
		Assert.assertEquals(expected, Solution().topKFrequent(words, k))
	}

	@Test
	fun `Example 2`() {
		val words = arrayOf("the","day","is","sunny","the","the","the","sunny","is","is")
		val k = 4
		val expected  = listOf("the","is","sunny","day")
		Assert.assertEquals(expected, Solution().topKFrequent(words, k))
	}
}

