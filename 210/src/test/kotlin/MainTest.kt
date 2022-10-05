import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val numCourses = 2
		val prerequisites = arrayOf(intArrayOf(1,0))
		val expected = listOf(0,1)
		Assert.assertEquals(expected, Solution().findOrder(numCourses, prerequisites).toList())
	}

	@Test
	fun `Example 2`() {
		val numCourses = 4
		val prerequisites = arrayOf(intArrayOf(1,0),intArrayOf(2,0),intArrayOf(3,1),intArrayOf(3,2))
		val expected = intArrayOf(0,1,2,3).toList()
		Assert.assertEquals(expected, Solution().findOrder(numCourses, prerequisites).toList())
	}

	@Test
	fun `Example 3`() {
		val numCourses = 1
		val prerequisites = arrayOf<IntArray>()
		val expected = intArrayOf(0).toList()
		Assert.assertEquals(expected, Solution().findOrder(numCourses, prerequisites).toList())
	}

	@Test
	fun `Example 4`() {
		val numCourses = 2
		val prerequisites = arrayOf(intArrayOf(0,1), intArrayOf(1, 0))
		val expected = intArrayOf().toList()
		Assert.assertEquals(expected, Solution().findOrder(numCourses, prerequisites).toList())
	}
}

