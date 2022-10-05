import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val arr = intArrayOf(5,5,4)
		val k = 1
		val expected = 1
		Assert.assertEquals(expected, Solution().findLeastNumOfUniqueInts(arr, k))
	}

	@Test
	fun `Example 2`() {
		val arr = intArrayOf(4,3,1,1,3,3,2)
		val k = 3
		val expected = 2
		Assert.assertEquals(expected, Solution().findLeastNumOfUniqueInts(arr, k))
	}

	@Test
	fun `Example 3`() {
		val arr = intArrayOf()
		val k = 0
		val expected = 0
		Assert.assertEquals(expected, Solution().findLeastNumOfUniqueInts(arr, k))
	}

	@Test
	fun `Example 4`() {
		val arr = intArrayOf(1, 1)
		val k = 3
		val expected = 0
		Assert.assertEquals(expected, Solution().findLeastNumOfUniqueInts(arr, k))
	}
}

