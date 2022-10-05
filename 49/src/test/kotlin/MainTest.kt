import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val strs = arrayOf("eat","tea","tan","ate","nat","bat")
		val expected = listOf(listOf("bat"),listOf("nat","tan"),listOf("ate","eat","tea"))
		Assert.assertEquals(expected, Solution().groupAnagrams(strs))
	}

	@Test
	fun `Example 2`() {
		val strs = arrayOf("")
		val expected = listOf(listOf(""))
		Assert.assertEquals(expected, Solution().groupAnagrams(strs))
	}

	@Test
	fun `Example 3`() {
		val strs = arrayOf("a")
		val expected = listOf(listOf("a"))
		Assert.assertEquals(expected, Solution().groupAnagrams(strs))
	}

	@Test
	fun `Example 4`() {
		val strs = arrayOf<String>()
		val expected = listOf<String>()
		Assert.assertEquals(expected, Solution().groupAnagrams(strs))
	}
}

