import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test 
	fun `Example 1`() {
		val grid = arrayOf(intArrayOf(3,1,1),intArrayOf(2,5,1),intArrayOf(1,5,5),intArrayOf(2,1,1))
		val expected = 24
		Assert.assertEquals(expected, Solution().cherryPickup(grid))
	}

	@Test 
	fun `Example 2`() {
		val grid = arrayOf(intArrayOf(1,0,0,0,0,0,1),intArrayOf(2,0,0,0,0,3,0),intArrayOf(2,0,9,0,0,0,0),intArrayOf(0,3,0,5,4,0,0),intArrayOf(1,0,2,3,0,0,6))
		val expected = 28
		Assert.assertEquals(expected, Solution().cherryPickup(grid))
	}

	@Test 
	fun `Example 9`() {
		val grid = arrayOf(intArrayOf(4,1,5,7,1),intArrayOf(6,0,4,6,4),intArrayOf(0,9,6,3,5))
		val expected = 32
		Assert.assertEquals(expected, Solution().cherryPickup(grid))
	}

	@Test 
	fun `Example 10`() {
		val grid = arrayOf(intArrayOf(8,8,10,9,1,7),intArrayOf(8,8,1,8,4,7),intArrayOf(8,6,10,3,7,7),intArrayOf(3,0,9,3,2,7),intArrayOf(6,8,9,4,2,5),intArrayOf(1,1,5,8,8,1),intArrayOf(5,6,5,2,9,9),intArrayOf(4,4,6,2,5,4),intArrayOf(4,4,5,3,1,6),intArrayOf(9,2,2,1,9,3))
		val expected = 146
		Assert.assertEquals(expected, Solution().cherryPickup(grid))
	}

	@Test 
	fun `Example 44`() {
		val grid = arrayOf(intArrayOf(3,8,7,10,10,9,8,2,9),intArrayOf(7,6,1,10,5,2,0,4,2),intArrayOf(0,0,0,7,5,6,2,10,5),intArrayOf(7,3,5,4,2,7,8,1,8),intArrayOf(0,3,7,1,4,9,7,7,7),intArrayOf(8,9,7,8,7,7,5,2,6),intArrayOf(2,4,5,4,7,0,8,7,7),intArrayOf(4,4,1,9,10,8,4,10,6),intArrayOf(9,9,4,10,3,10,3,2,1))
		val expected = 130
		Assert.assertEquals(expected, Solution().cherryPickup(grid))
	}
}

