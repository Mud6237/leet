import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val length = 5
		val updates = arrayOf(intArrayOf(1,3,2),intArrayOf(2,4,3),intArrayOf(0,2,-2)) 
		val expected = intArrayOf(-2,0,3,5,3).toList()
		Assert.assertEquals(expected, Solution().getModifiedArray(length, updates).toList())
	}

	@Test
	fun `Example 2`() {
		val length = 10
		val updates = arrayOf(intArrayOf(2,4,6),intArrayOf(5,6,8),intArrayOf(1,9,-4))
		val expected = intArrayOf(0,-4,2,2,2,4,4,-4,-4,-4).toList()
		Assert.assertEquals(expected, Solution().getModifiedArray(length, updates).toList())
	}
}

