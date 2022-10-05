import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val s = "25525511135"
		val expected = listOf("255.255.11.135","255.255.111.35")
		Assert.assertEquals(expected, Solution().restoreIpAddresses(s))
	}
	@Test
	fun `Example 2`() {
		val s = "0000"
		val expected = listOf("0.0.0.0")
		Assert.assertEquals(expected, Solution().restoreIpAddresses(s))
	}
	@Test
	fun `Example 3`() {
		val s = "101023"
		val expected = listOf("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3")
		Assert.assertEquals(expected, Solution().restoreIpAddresses(s))
	}
	@Test
	fun `Example 4`() {
		val s = "0011255245"
		val expected = listOf<String>()
		Assert.assertEquals(expected, Solution().restoreIpAddresses(s))
	}

	@Test
	fun `Example 5`() {
		val s = "1921681312"
		val expected = listOf<String>("192.168.13.12", "192.168.131.2")
		Assert.assertEquals(expected, Solution().restoreIpAddresses(s))
	}

	@Test
	fun `Example 6`() {
		val s = "192168@11"
		val expected = listOf<String>()
		Assert.assertEquals(expected, Solution().restoreIpAddresses(s))
	}

}

