import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val boxTypes = arrayOf(intArrayOf(1,3),intArrayOf(2,2),intArrayOf(3,1))
		val truckSize = 4
		val expected = 8
		Assert.assertEquals(expected, Solution().maximumUnits(boxTypes, truckSize))
	}

	@Test
	fun `Example 2`() {
		val boxTypes = arrayOf(intArrayOf(5,10),intArrayOf(2,5),intArrayOf(4,7),intArrayOf(3,9))
		val truckSize = 10
		val expected = 91
		Assert.assertEquals(expected, Solution().maximumUnits(boxTypes, truckSize))
	}
}

