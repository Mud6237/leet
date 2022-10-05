import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val points = arrayOf(intArrayOf(1,1),intArrayOf(2,2),intArrayOf(3,3))
		val expected = 3
		Assert.assertEquals(expected, Solution().maxPoints(points))
	}

	@Test
	fun `Example 2`() {
		val points = arrayOf(intArrayOf(1,1),intArrayOf(3,2),intArrayOf(5,3),intArrayOf(4,1),intArrayOf(2,3),intArrayOf(1,4))
		val expected = 4
		Assert.assertEquals(expected, Solution().maxPoints(points))
	}

	@Test
	fun `Example 3`() {
		val points = arrayOf(intArrayOf(1,1), intArrayOf(1,4))
		val expected = 2
		Assert.assertEquals(expected, Solution().maxPoints(points))
	}

	@Test
	fun `Example 32`() {
		val points = arrayOf(intArrayOf(7,3),intArrayOf(19,19),intArrayOf(-16,3),intArrayOf(13,17),intArrayOf(-18,1),intArrayOf(-18,-17),intArrayOf(13,-3),intArrayOf(3,7),intArrayOf(-11,12),intArrayOf(7,19),intArrayOf(19,-12),intArrayOf(20,-18),intArrayOf(-16,-15),intArrayOf(-10,-15),intArrayOf(-16,-18),intArrayOf(-14,-1),intArrayOf(18,10),intArrayOf(-13,8),intArrayOf(7,-5),intArrayOf(-4,-9),intArrayOf(-11,2),intArrayOf(-9,-9),intArrayOf(-5,-16),intArrayOf(10,14),intArrayOf(-3,4),intArrayOf(1,-20),intArrayOf(2,16),intArrayOf(0,14),intArrayOf(-14,5),intArrayOf(15,-11),intArrayOf(3,11),intArrayOf(11,-10),intArrayOf(-1,-7),intArrayOf(16,7),intArrayOf(1,-11),intArrayOf(-8,-3),intArrayOf(1,-6),intArrayOf(19,7),intArrayOf(3,6),intArrayOf(-1,-2),intArrayOf(7,-3),intArrayOf(-6,-8),intArrayOf(7,1),intArrayOf(-15,12),intArrayOf(-17,9),intArrayOf(19,-9),intArrayOf(1,0),intArrayOf(9,-10),intArrayOf(6,20),intArrayOf(-12,-4),intArrayOf(-16,-17),intArrayOf(14,3),intArrayOf(0,-1),intArrayOf(-18,9),intArrayOf(-15,15),intArrayOf(-3,-15),intArrayOf(-5,20),intArrayOf(15,-14),intArrayOf(9,-17),intArrayOf(10,-14),intArrayOf(-7,-11),intArrayOf(14,9),intArrayOf(1,-1),intArrayOf(15,12),intArrayOf(-5,-1),intArrayOf(-17,-5),intArrayOf(15,-2),intArrayOf(-12,11),intArrayOf(19,-18),intArrayOf(8,7),intArrayOf(-5,-3),intArrayOf(-17,-1),intArrayOf(-18,13),intArrayOf(15,-3),intArrayOf(4,18),intArrayOf(-14,-15),intArrayOf(15,8),intArrayOf(-18,-12),intArrayOf(-15,19),intArrayOf(-9,16),intArrayOf(-9,14),intArrayOf(-12,-14),intArrayOf(-2,-20),intArrayOf(-3,-13),intArrayOf(10,-7),intArrayOf(-2,-10),intArrayOf(9,10),intArrayOf(-1,7),intArrayOf(-17,-6),intArrayOf(-15,20),intArrayOf(5,-17),intArrayOf(6,-6),intArrayOf(-11,-8))
		val expected = 6
		Assert.assertEquals(expected, Solution().maxPoints(points))
	}

}

