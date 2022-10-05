import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val heights = intArrayOf(10,6,8,5,11,9)
		val expected = intArrayOf(3,1,2,1,1,0).toList()
		Assert.assertEquals(expected, Solution().canSeePersonsCount(heights).toList())
	}

	@Test
	fun `Example 2`() {
		val heights = intArrayOf(5,1,2,3,10)
		val expected = intArrayOf(4,1,1,1,0).toList()
		Assert.assertEquals(expected, Solution().canSeePersonsCount(heights).toList())
	}
}

