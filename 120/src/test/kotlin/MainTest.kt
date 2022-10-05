import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val triangle = listOf(listOf(2),listOf(3,4),listOf(6,5,7),listOf(4,1,8,3))
		val expected = 11
		Assert.assertEquals(expected, Solution().minimumTotal(triangle))
	}
}

