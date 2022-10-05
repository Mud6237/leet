import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val intervals = arrayOf(intArrayOf(1,3),intArrayOf(2,6),intArrayOf(8,10),intArrayOf(15,18))
		val expected = arrayOf(listOf(1,6),listOf(8,10),listOf(15,18)).toList()
		Assert.assertEquals(expected, Solution().merge(intervals).map {it.toList()})
	}

	@Test
	fun `Example 2`() {
		val intervals = arrayOf(intArrayOf(1,4),intArrayOf(4,5))
		val expected = arrayOf(listOf(1,5)).toList()
		Assert.assertEquals(expected, Solution().merge(intervals).map {it.toList()})
	}
}

