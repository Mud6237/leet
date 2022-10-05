import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val input = listOf(listOf("MUC","LHR"),listOf("JFK","MUC"),listOf("SFO","SJC"),listOf("LHR","SFO"))
		val expected = listOf("JFK","MUC","LHR","SFO","SJC")
		Assert.assertEquals(expected, Solution().findItinerary(input))
	}
	@Test
	fun `Example 2`() {
		val input = listOf(listOf("JFK","SFO"),listOf("JFK","ATL"),listOf("SFO","ATL"),listOf("ATL","JFK"),listOf("ATL","SFO"))
		val expected = listOf("JFK","ATL","JFK","SFO","ATL","SFO")
		Assert.assertEquals(expected, Solution().findItinerary(input))
	}
	@Test
	fun `Example 3`() {
		val input = listOf(listOf("JFK","SFO"))
		val expected = listOf("JFK","SFO")
		Assert.assertEquals(expected, Solution().findItinerary(input))
	}
}

