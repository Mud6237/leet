import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val numCourses = 2
		val prerequisites = arrayOf(intArrayOf(1,0))
		val expected = true
		Assert.assertEquals(expected, Solution().canFinish(numCourses, prerequisites))
	}

	@Test
	fun `Example 2`() {
		val numCourses = 2
		val prerequisites = arrayOf(intArrayOf(1,0),intArrayOf(0,1))
		val expected = false
		Assert.assertEquals(expected, Solution().canFinish(numCourses, prerequisites))
	}
}

