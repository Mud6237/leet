import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val words = arrayOf("abcd","dcba","lls","s","sssll")
		val expected = listOf(listOf(0,1),listOf(1,0),listOf(3,2),listOf(2,4))
		Assert.assertEquals(expected, Solution().palindromePairs(words))
	}
	@Test
	fun `Example 2`() {
		val words = arrayOf("bat","tab","cat")
		val expected = listOf(listOf(0,1),listOf(1,0))
		Assert.assertEquals(expected, Solution().palindromePairs(words))
	}
	@Test
	fun `Example 3`() {
		val words = arrayOf("a", "")
		val expected = listOf(listOf(0,1),listOf(1,0))
		Assert.assertEquals(expected, Solution().palindromePairs(words))
	}
	@Test
	fun `Example 4`() {
		val words = arrayOf("abcd", "dcba", "", "sl", "s")
		val expected = listOf(listOf(0,1),listOf(1,0), listOf(3, 4), listOf(4, 2), listOf(2, 4))
		Assert.assertEquals(expected, Solution().palindromePairs(words))
	}
}

