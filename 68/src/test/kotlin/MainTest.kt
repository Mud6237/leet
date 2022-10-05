import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val words = arrayOf("This", "is", "an", "example", "of", "text", "justification.")
		val maxWidth = 16
		val expected = listOf(
			"This    is    an",
			"example  of text",
			"justification.  "
		)
		Assert.assertEquals(expected, Solution().fullJustify(words, maxWidth))
	}

	@Test
	fun `Example 2`() {
		val words = arrayOf("What","must","be","acknowledgment","shall","be")
		val maxWidth = 16
		val expected = listOf(
			"What   must   be",
  		"acknowledgment  ",
  		"shall be        "
		)
		Assert.assertEquals(expected, Solution().fullJustify(words, maxWidth))
	}

	@Test
	fun `Example 3`() {
		val words = arrayOf("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do")
		val maxWidth = 20
		val expected = listOf(
			"Science  is  what we",
			"understand      well",
			"enough to explain to",
			"a  computer.  Art is",
			"everything  else  we",
			"do                  "
		)
		Assert.assertEquals(expected, Solution().fullJustify(words, maxWidth))
	}
}

