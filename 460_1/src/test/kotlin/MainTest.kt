import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val lfu = LFUCache(2)
		lfu.put(1, 1)
		lfu.put(2, 2)
		Assert.assertEquals(1, lfu.get(1))
		lfu.put(3, 3)
		Assert.assertEquals(-1, lfu.get(2))
		Assert.assertEquals(3, lfu.get(3))
		lfu.put(4, 4)
		Assert.assertEquals(-1, lfu.get(1))
		Assert.assertEquals(3, lfu.get(3))		
		Assert.assertEquals(4, lfu.get(4))
	}

	@Test
	fun `Example 2`() {
		val lfu = LFUCache(2)
		lfu.put(1, 1)
		lfu.put(2, 2)
		lfu.put(2, 20)
		lfu.put(1, 10)
		lfu.put(3, 3)
		Assert.assertEquals(10, lfu.get(1))
		lfu.put(3, 30)
		Assert.assertEquals(30, lfu.get(3))
		lfu.put(3, 90)
		//Assert.assertEquals(3, lfu.get(3))
		//lfu.put(4, 4)
		//Assert.assertEquals(-1, lfu.get(1))
		//Assert.assertEquals(3, lfu.get(3))		
		//Assert.assertEquals(4, lfu.get(4))
	}

	@Test
	fun `Example 22`() {
		val lfu = LFUCache(3)
		lfu.put(2,2)
		lfu.put(1,1)
		Assert.assertEquals(2, lfu.get(2))
		Assert.assertEquals(1, lfu.get(1))
		Assert.assertEquals(2, lfu.get(2))
		lfu.put(3,3)
		lfu.put(4,4)
		Assert.assertEquals(-1, lfu.get(3))
		Assert.assertEquals(2, lfu.get(2))
		Assert.assertEquals(1, lfu.get(1))
		Assert.assertEquals(4, lfu.get(4))
	}

	@Test
	fun `Example 25`() {
		val lfu = LFUCache(0)
		lfu.put(0,0)
		Assert.assertEquals(-1, lfu.get(0))
	}
}