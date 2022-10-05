import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val intervals = arrayOf(intArrayOf(0,30),intArrayOf(5,10),intArrayOf(15,20))
		val expected = 2
		Assert.assertEquals(expected, Solution().minMeetingRooms(intervals))
	}

	@Test
	fun `Example 2`() {
		val intervals = arrayOf(intArrayOf(7,10),intArrayOf(2,4))
		val expected = 1
		Assert.assertEquals(expected, Solution().minMeetingRooms(intervals))
	}

	@Test
	fun `Example 43`() {
		val intervals = arrayOf(intArrayOf(13,15),intArrayOf(1,13))
		val expected = 1
		Assert.assertEquals(expected, Solution().minMeetingRooms(intervals))
	}

	@Test
	fun `Example 51`() {
		val intervals = arrayOf(intArrayOf(9,10),intArrayOf(4,9), intArrayOf(4, 17))
		val expected = 2
		Assert.assertEquals(expected, Solution().minMeetingRooms(intervals))
	}

	@Test
	fun `Example 54`() {
		val intervals = arrayOf(intArrayOf(2,11),intArrayOf(6,16), intArrayOf(11, 16))
		val expected = 2
		Assert.assertEquals(expected, Solution().minMeetingRooms(intervals))
	}

	@Test
	fun `Example 60`() {
		val intervals = arrayOf(intArrayOf(9,14),intArrayOf(5,6), intArrayOf(3, 5), intArrayOf(12, 19))
		val expected = 2
		Assert.assertEquals(expected, Solution().minMeetingRooms(intervals))
	}
}

