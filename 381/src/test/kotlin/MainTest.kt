import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val r = RandomizedCollection()
		Assert.assertEquals(true, r.insert(1))
		Assert.assertEquals(false, r.insert(1))
		Assert.assertEquals(true, r.insert(2))
		Assert.assertEquals(true, r.remove(1))
		Assert.assertEquals(false, r.remove(20))
		Assert.assertEquals(true, r.remove(2))
		Assert.assertEquals(1, r.getRandom())
	}
}

