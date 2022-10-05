import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		
		val intervals = arrayOf(intArrayOf(1,3),intArrayOf(6,9))
		val newInterval = intArrayOf(2,5)
		val expected = listOf(listOf(1,5),listOf(6,9))
		val actual = Solution().insert(intervals, newInterval).map( { it.toList() })
		Assert.assertEquals(expected, actual)
	}
	@Test 
	fun `Example 2`() {
		val intervals = arrayOf(intArrayOf(1,2),intArrayOf(3,5),intArrayOf(6,7),intArrayOf(8,10),intArrayOf(12,16))
		val newInterval = intArrayOf(4,8)
		val expected = listOf(listOf(1,2),listOf(3,10),listOf(12,16))
		val actual = Solution().insert(intervals, newInterval).map( { it.toList() })
		Assert.assertEquals(expected, actual)
	}

	@Test 
	fun `Example 3`() {
		val intervals = arrayOf<IntArray>()
		val newInterval = intArrayOf(5, 7)
		val expected = listOf(listOf(5,7))
		val actual = Solution().insert(intervals, newInterval).map( { it.toList() })
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 4`() {
		val intervals = arrayOf(intArrayOf(1, 5))
		val newInterval = intArrayOf(2, 3)
		val expected = listOf(listOf(1, 5))
		val actual = Solution().insert(intervals, newInterval).map( { it.toList() })
		Assert.assertEquals(expected, actual)
	}
}

