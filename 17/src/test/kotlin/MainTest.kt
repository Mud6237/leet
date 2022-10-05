import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val expected = listOf("ad","ae","af","bd","be","bf","cd","ce","cf")
		Assert.assertEquals(expected, Solution().letterCombinations("23"))
	}
	@Test
	fun `Example 2`() {
		val expected = listOf<String>()
		Assert.assertEquals(expected, Solution().letterCombinations(""))
	}
	@Test
	fun `Example 3`() {
		val expected = listOf<String>("a", "b", "c")
		Assert.assertEquals(expected, Solution().letterCombinations("2"))
	}
}

