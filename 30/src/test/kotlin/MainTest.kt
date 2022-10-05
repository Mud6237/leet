import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "barfoothefoobarman"
		val words = arrayOf("foo","bar")
		val expected = listOf(0, 9)
		Assert.assertEquals(expected, Solution().findSubstring(s, words))
	}
	@Test
	fun `Example 2`() {
		val s = "wordgoodgoodgoodbestword"
		val words = arrayOf("word","good","best","word")
		val expected = listOf<Int>()
		Assert.assertEquals(expected, Solution().findSubstring(s, words))
	}
	
	@Test
	fun `Example 3`() {
		val s = "barfoofoobarthefoobarman"
		val words = arrayOf("bar","foo","the")
		val expected = listOf<Int>(6, 9, 12)
		Assert.assertEquals(expected, Solution().findSubstring(s, words))
	}
}

