import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val allOne = AllOne()
		allOne.inc("hello")
		allOne.inc("hello")
		Assert.assertEquals("hello", allOne.getMaxKey())
		Assert.assertEquals("hello", allOne.getMinKey())
		allOne.inc("leet")
		Assert.assertEquals("hello", allOne.getMaxKey())
		Assert.assertEquals("leet", allOne.getMinKey())
		allOne.inc("leet")
		allOne.inc("leet")
		Assert.assertEquals("leet", allOne.getMaxKey())
		Assert.assertEquals("hello", allOne.getMinKey())
		allOne.inc("hello")
		allOne.inc("hello")
		allOne.inc("leet")
		allOne.inc("leet")
		Assert.assertEquals("hello", allOne.getMinKey())
		Assert.assertEquals("leet", allOne.getMaxKey())
		allOne.inc("hi")
		allOne.inc("hi")
		allOne.inc("hi")
		allOne.inc("hello")
		allOne.inc("hi")
		allOne.inc("hi")
		allOne.inc("hi")
		Assert.assertEquals("hi", allOne.getMaxKey())
		Assert.assertEquals("hello", allOne.getMinKey())

		allOne.dec("hi")
		allOne.dec("hi")
		allOne.dec("hi")
		allOne.dec("hi")
		allOne.dec("hi")
		allOne.dec("hi")

		allOne.dec("leet")
		allOne.dec("leet")
		
		Assert.assertEquals("leet", allOne.getMinKey())
		allOne.dec("hello")
		allOne.dec("hello")
		allOne.dec("hello")
		allOne.dec("hello")
		allOne.dec("hello")
		Assert.assertEquals("leet", allOne.getMinKey())
		allOne.dec("leet")
		allOne.dec("leet")
		Assert.assertEquals("leet",allOne.getMinKey())
		allOne.inc("ABC")
		allOne.dec("leet")
		Assert.assertEquals("ABC",allOne.getMinKey())
		allOne.dec("ABC")
		Assert.assertEquals("",allOne.getMinKey())
		allOne.inc("ABC")
		Assert.assertEquals("ABC",allOne.getMinKey())
		Assert.assertEquals("ABC",allOne.getMaxKey())
	}

	@Test
	fun `Example 2`() {
		/*
			["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
	[[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
		// [null,null,null,null,null,null,null,null,null,"a",null,"c","c"]
		*/
		val allOne = AllOne()
		allOne.inc("a")
		allOne.inc("b")
		allOne.inc("b")
		allOne.inc("c")
		allOne.inc("c")
		allOne.inc("c")
		allOne.dec("b")
		allOne.dec("b")
		Assert.assertEquals("a", allOne.getMinKey())
		allOne.dec("a")
		Assert.assertEquals("c", allOne.getMaxKey())
		Assert.assertEquals("c", allOne.getMinKey())
	}
}

