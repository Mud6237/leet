import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val dungeon = arrayOf(intArrayOf(-2,-3,3),intArrayOf(-5,-10,1),intArrayOf(10,30,-5))
		val expected = 7
		Assert.assertEquals(expected, Solution().calculateMinimumHP(dungeon))
	}

	@Test
	fun `Example 2`() {
		val dungeon = arrayOf(intArrayOf(0))
		val expected = 1
		Assert.assertEquals(expected, Solution().calculateMinimumHP(dungeon))
	}

	@Test
	fun `Example 3`() {
		val dungeon = arrayOf(intArrayOf(0,0))
		val expected = 1
		Assert.assertEquals(expected, Solution().calculateMinimumHP(dungeon))
	}

	@Test
	fun `Example 4`() {
		val dungeon = arrayOf(intArrayOf(1,-1))
		val expected = 1
		Assert.assertEquals(expected, Solution().calculateMinimumHP(dungeon))
	}

	@Test
	fun `Example 40`() {
		val dungeon = arrayOf(intArrayOf(100))
		val expected = 1
		Assert.assertEquals(expected, Solution().calculateMinimumHP(dungeon))
	}

	@Test
	fun `Example 42`() {
		val dungeon = arrayOf(intArrayOf(-3,5))
		val expected = 4
		Assert.assertEquals(expected, Solution().calculateMinimumHP(dungeon))
	}
}

