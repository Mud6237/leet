import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val cells = intArrayOf(0,1,0,1,1,0,0,1)
		val n = 7
		val expected = listOf(0,0,1,1,0,0,0,0)
		Assert.assertEquals(expected, Solution().prisonAfterNDays(cells, n).toList())
	}

	@Test
	fun `Example 2`() {
		val cells = intArrayOf(1,0,0,1,0,0,1,0)
		val n = 1_000_000_000
		val expected = listOf(0,0,1,1,1,1,1,0)
		Assert.assertEquals(expected, Solution().prisonAfterNDays(cells, n).toList())
	}

	@Test
	fun `Example 3`() {
		val cells = intArrayOf(0,0,1,1,1,0,0,0)
		val n = 682_529_619
		val expected = listOf(0, 1, 0, 0, 1, 0, 1, 0)
		Assert.assertEquals(expected, Solution().prisonAfterNDays(cells, n).toList())
	}
}

