import org.junit.Test
import org.junit.Ignore
import org.junit.Assert

class MainTest {
	@Test 
	fun `Example 1`() {
		val n = 1
		val k = 6
		val target = 3
		val expected = 1
		Assert.assertEquals(expected, Solution().numRollsToTarget(n,k,target))
	}

	@Test 
	fun `Example 2`() {
		val n = 2
		val k = 6
		val target = 7
		val expected = 6
		Assert.assertEquals(expected, Solution().numRollsToTarget(n,k,target))
	}

	@Test 
	fun `Example 3`() {
		val n = 30
		val k = 30
		val target = 500
		val expected = 222616187
		Assert.assertEquals(expected, Solution().numRollsToTarget(n,k,target))
	}
	
	@Test 
	fun `Example 4`() {
		val n = 3
		val k = 6
		val target = 9
		val expected = 25
		Assert.assertEquals(expected, Solution().numRollsToTarget(n,k,target))
	}
	@Test 
	fun `Example 13`() {
		val n = 2
		val k = 12
		val target = 8
		val expected = 7
		Assert.assertEquals(expected, Solution().numRollsToTarget(n,k,target))
	}
}

