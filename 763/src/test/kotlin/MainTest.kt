import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "ababcbacadefegdehijhklij"
		val expected = listOf(9, 7, 8)
		Assert.assertEquals(expected, Solution().partitionLabels(s))
	}

	@Test
	fun `Example 2`() {
		val s = "eccbbbbdec"
		val expected = listOf(10)
		Assert.assertEquals(expected, Solution().partitionLabels(s))
	}
	
	@Test
	fun `Example 3`() {
		val s = "e"
		val expected = listOf(1)
		Assert.assertEquals(expected, Solution().partitionLabels(s))
	}

	@Test
	fun `Example 4`() {
		val s = "ea"
		val expected = listOf(1,1)
		Assert.assertEquals(expected, Solution().partitionLabels(s))
	}

	@Test
	fun `Example 5`() {
		val s = ""
		val expected = emptyList<Int>()
		Assert.assertEquals(expected, Solution().partitionLabels(s))
	}
}

