import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val schedule = arrayListOf(arrayListOf(Interval(1,2),Interval(5,6)),arrayListOf(Interval(1,3)),arrayListOf(Interval(4,10)))
		val expected = mutableListOf(Interval(3,4))
		val expectedStringBuilder = StringBuilder()
		for(e in expected) {
			expectedStringBuilder.append(e.start,e.end)
		}
		val actual = Solution().employeeFreeTime(schedule)
		val actualStringBuilder = StringBuilder()
		for(e in actual) {
			actualStringBuilder.append(e.start,e.end)
		}
		Assert.assertEquals(expectedStringBuilder.toString(), actualStringBuilder.toString())
	}
	@Test
	fun `Example 2`() {
		val schedule = arrayListOf(arrayListOf(Interval(1,3),Interval(6,7)),arrayListOf(Interval(2,4)),arrayListOf(Interval(2,5),Interval(9,12)))
		val expected = mutableListOf(Interval(5,6), Interval(7, 9))
		val expectedStringBuilder = StringBuilder()
		for(e in expected) {
			expectedStringBuilder.append(e.start,e.end)
		}
		val actual = Solution().employeeFreeTime(schedule)
		val actualStringBuilder = StringBuilder()
		for(e in actual) {
			actualStringBuilder.append(e.start,e.end)
		}
		Assert.assertEquals(expectedStringBuilder.toString(), actualStringBuilder.toString())
	}
}

