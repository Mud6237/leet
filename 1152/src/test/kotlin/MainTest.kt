import org.junit.Test
import org.junit.Ignore
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val username = arrayOf("joe","joe","joe","james","james","james","james","mary","mary","mary")
		val timestamp = intArrayOf(1,2,3,4,5,6,7,8,9,10)

		val website = arrayOf("home","about","career","home","cart","maps","home","home","about","career")

		//home
		//	cart
		//		maps
		//		home
		//	maps
		//		home
		//cart
		//	maps
		//		home
		
		val expected = listOf("home","about","career")
		Assert.assertEquals(expected, Solution().mostVisitedPattern(username, timestamp, website))
	}

	@Test
	fun `Example 2`() {
		val username = arrayOf("ua","ua","ua","ub","ub","ub")
		val timestamp = intArrayOf(1,2,3,4,5,6)
		val website = arrayOf("a","b","a","a","b","c")
		val expected = listOf("a","b","a")
		Assert.assertEquals(expected, Solution().mostVisitedPattern(username, timestamp, website))
	}

	@Test
	fun `Example 16`() {
		val username = arrayOf("dowg","dowg","dowg")
		val timestamp = intArrayOf(158931262,562600350,148438945)
		val website = arrayOf("y","loedo","y")
		val expected = listOf("y","y","loedo")
		Assert.assertEquals(expected, Solution().mostVisitedPattern(username, timestamp, website))
	}

	@Test
	fun `Example 30`() {
		val username = arrayOf("ldigebxndh","jxm","iit","ldigebxndh","dut","oxkr","dut","ldigebxndh","iit")
		val timestamp = intArrayOf(246561774,336877562,613255786,581611682,67005296,164162280,644105652,998777950,962088025)
		val website = arrayOf("kzx","bsmy","qhmiliihh","txvn","snf","nrtj","ksakw","bsmy","txvn")
		val expected = listOf("kzx","txvn","bsmy")
		Assert.assertEquals(expected, Solution().mostVisitedPattern(username, timestamp, website))
	}

	@Test
	fun `Example 38`() {
		val username = arrayOf("h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq")
		val timestamp = intArrayOf(527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930)
		val website = arrayOf("hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw")
		val expected = listOf("hibympufi","hibympufi","yljmntrclw")
		Assert.assertEquals(expected, Solution().mostVisitedPattern(username, timestamp, website))
	}
}

