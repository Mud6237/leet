import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val nums = listOf(listOf(4,10,15,24,26),listOf(0,9,12,20),listOf(5,18,22,30))
		val expected = listOf(20,24).toList()
		Assert.assertEquals(expected, Solution().smallestRange(nums).toList())
	}
	@Test
	fun `Example 2`() {
		val nums = listOf(listOf(1,2,3),listOf(1,2,3),listOf(1,2,3))
		val expected = listOf(1,1)
		Assert.assertEquals(expected, Solution().smallestRange(nums).toList())
	}
}

