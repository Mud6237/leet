import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val pid = listOf(1,3,10,5)
		val ppid = listOf(3,0,5,3)
		val kill = 5
		val expected = listOf(5,10)
		Assert.assertEquals(expected, Solution().killProcess(pid, ppid, kill))
	}

	@Test
	fun `Example 3`() {
		val pid = listOf(1,3,10,5)
		val ppid = listOf(3,0,5,3)
		val kill = 3
		val expected = listOf(3, 1, 5, 10)
		Assert.assertEquals(expected, Solution().killProcess(pid, ppid, kill))
	}

	@Test
	fun `Example 2`() {
		val pid = listOf(1)
		val ppid = listOf(0)
		val kill = 1
		val expected = listOf(1)
		Assert.assertEquals(expected, Solution().killProcess(pid, ppid, kill))
	}

	@Test
	fun `Example 4`() {
		val pid = listOf(1)
		val ppid = listOf(0)
		val kill = 1
		val expected = listOf(1)
		Assert.assertEquals(expected, Solution().killProcess(pid, ppid, kill))
	}

	@Test
	fun `Example 109`() {
		val pid = listOf(1,4,5,6,8,9,3,2,10)
		val ppid = listOf(6,1,6,0,2,10,1,10,6)
		val kill = 10
		val expected = listOf(10,9,2,8)
		Assert.assertEquals(expected, Solution().killProcess(pid, ppid, kill))
	}

	@Test
	fun `Example 120`() {
		val pid = listOf(1,3,5,4,8,6,10,2)
		val ppid = listOf(5,1,8,5,10,0,6,5)
		val kill = 10
		val expected = listOf(10,8,5,1,4,2,3)
		Assert.assertEquals(expected, Solution().killProcess(pid, ppid, kill))
	}
}

