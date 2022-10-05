import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val tasks = intArrayOf(3, 2, 1)
		val workers = intArrayOf(0, 3, 3)
		val pills = 1
		val strength = 1
		val expected = 3
		Assert.assertEquals(expected, Solution().maxTaskAssign(tasks, workers, pills, strength))
	}

	@Test
	fun `Example 2`() {
		val tasks = intArrayOf(5, 4)
		val workers = intArrayOf(0,0,0)
		val pills = 1
		val strength = 5
		val expected = 1
		Assert.assertEquals(expected, Solution().maxTaskAssign(tasks, workers, pills, strength))
	}

	@Test
	fun `Example 3`() {
		val tasks = intArrayOf(10,15,30)
		val workers = intArrayOf(0,10,10,10,10)
		val pills = 3
		val strength = 10
		val expected = 2
		Assert.assertEquals(expected, Solution().maxTaskAssign(tasks, workers, pills, strength))
	}

	@Test
	fun `Example 4`() {
		val tasks = intArrayOf(5,9,8,5,9)
		val workers = intArrayOf(1,6,4,2,6)
		val pills = 1
		val strength = 5
		val expected = 3
		Assert.assertEquals(expected, Solution().maxTaskAssign(tasks, workers, pills, strength))
	}
}

