import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val transactions = arrayOf(intArrayOf(0,1,10),intArrayOf(2,0,5))
		val expected = 2
		Assert.assertEquals(expected, Solution().minTransfers(transactions))
	}
	@Test
	fun `Example 2`() {
		val transactions = arrayOf(intArrayOf(0,1,10),intArrayOf(1,0,1),intArrayOf(1,2,5),intArrayOf(2,0,5))
		val expected = 1
		Assert.assertEquals(expected, Solution().minTransfers(transactions))
	}
	@Test
	fun `Example 3`() {
		val transactions = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 4), intArrayOf(2, 3, 2), intArrayOf(4, 2, 1))
		val expected = 3
		Assert.assertEquals(expected, Solution().minTransfers(transactions))
	}
	@Test
	fun `Example 4`() {
		val transactions = arrayOf(intArrayOf(1,5,1),intArrayOf(3,5,3),intArrayOf(5,2,2),intArrayOf(5,4,2))
		val expected = 3
		Assert.assertEquals(expected, Solution().minTransfers(transactions))
	}
}

