import org.junit.Test
import org.junit.Assert
import org.junit.Ignore


class MainTest {
	@Test
	fun `Example 1`() {
		val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
		val expected = listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))
		Assert.assertEquals(expected, Solution().threeSum(nums))
	}

	@Test
	fun `Example 2`() {
		val nums = intArrayOf()
		val expected = listOf<List<Int>>()
		Assert.assertEquals(expected, Solution().threeSum(nums))
	}

	@Test
	fun `Example 3`() {
		val nums = intArrayOf(0)
		val expected = listOf<List<Int>>()
		Assert.assertEquals(expected, Solution().threeSum(nums))
	}

	@Test
	fun `Example 42`() {
		val nums = intArrayOf(0,0,0)
		val expected = listOf(listOf(0,0,0))
		Assert.assertEquals(expected, Solution().threeSum(nums))
	}

	@Test
	fun `Example 50`() {
		val nums = intArrayOf(1,1,-2)
		val expected = listOf(listOf(-2,1,1))
		Assert.assertEquals(expected, Solution().threeSum(nums))
	}

	@Test
	fun `Example 40`() {
		val nums = intArrayOf(1,-1,-1,0)
		val expected = listOf(listOf(-1,0,1))
		Assert.assertEquals(expected, Solution().threeSum(nums))
	}

	@Test
	fun `Example 165`() {
		val nums = intArrayOf(-1,0,1,2,-1,-4,-2,-3,3,0,4)
		val expected =listOf(listOf(-4,0,4),listOf(-4,1,3),listOf(-3,-1,4),listOf(-3,0,3),listOf(-3,1,2),listOf(-2,-1,3),listOf(-2,0,2),listOf(-1,-1,2),listOf(-1,0,1))
		Assert.assertEquals(expected, Solution().threeSum(nums))
	}

	@Test
	fun `Example 69`() {
		val nums = intArrayOf(0,0,0,0)
		val expected =listOf(listOf(0,0,0))
		Assert.assertEquals(expected, Solution().threeSum(nums))
	}
	@Test
	fun `Example 192`() {
		val nums = intArrayOf(34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49)
		val expected = listOf(listOf(-82,-11,93),listOf(-82,13,69),listOf(-82,17,65),listOf(-82,21,61),listOf(-82,26,56),listOf(-82,33,49),listOf(-82,34,48),listOf(-82,36,46),listOf(-70,-14,84),listOf(-70,-6,76),listOf(-70,1,69),listOf(-70,13,57),listOf(-70,15,55),listOf(-70,21,49),listOf(-70,34,36),listOf(-66,-11,77),listOf(-66,-3,69),listOf(-66,1,65),listOf(-66,10,56),listOf(-66,17,49),listOf(-49,-6,55),listOf(-49,-3,52),listOf(-49,1,48),listOf(-49,2,47),listOf(-49,13,36),listOf(-49,15,34),listOf(-49,21,28),listOf(-43,-14,57),listOf(-43,-6,49),listOf(-43,-3,46),listOf(-43,10,33),listOf(-43,12,31),listOf(-43,15,28),listOf(-43,17,26),listOf(-29,-14,43),listOf(-29,1,28),listOf(-29,12,17),listOf(-14,-3,17),listOf(-14,1,13),listOf(-14,2,12),listOf(-11,-6,17),listOf(-11,1,10),listOf(-3,1,2))
		Assert.assertEquals(expected, Solution().threeSum(nums))
	}
}
