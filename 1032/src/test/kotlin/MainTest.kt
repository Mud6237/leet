import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val words = arrayOf("ab","ba","aaab","abab","baa")
		val streamChecker = StreamChecker(words)
		Assert.assertEquals(false, streamChecker.query('a'))
		Assert.assertEquals(false, streamChecker.query('a'))
		Assert.assertEquals(false, streamChecker.query('a'))
		Assert.assertEquals(false, streamChecker.query('a'))
		Assert.assertEquals(false, streamChecker.query('a'))
		Assert.assertEquals(true, streamChecker.query('b'))
		Assert.assertEquals(true, streamChecker.query('a'))
		Assert.assertEquals(true, streamChecker.query('b'))
		Assert.assertEquals(true, streamChecker.query('a'))
		Assert.assertEquals(true, streamChecker.query('b'))
		Assert.assertEquals(false, streamChecker.query('b'))
		Assert.assertEquals(false, streamChecker.query('b'))
		Assert.assertEquals(true, streamChecker.query('a'))
		Assert.assertEquals(true, streamChecker.query('b'))
		Assert.assertEquals(true, streamChecker.query('a'))
		Assert.assertEquals(true, streamChecker.query('b'))
		Assert.assertEquals(false, streamChecker.query('b'))
		Assert.assertEquals(false, streamChecker.query('b'))
		Assert.assertEquals(false, streamChecker.query('b'))
		Assert.assertEquals(true, streamChecker.query('a'))
		Assert.assertEquals(true, streamChecker.query('b'))
		Assert.assertEquals(true, streamChecker.query('a'))
		Assert.assertEquals(true, streamChecker.query('b'))
		Assert.assertEquals(true, streamChecker.query('a'))
		Assert.assertEquals(true, streamChecker.query('a'))
		Assert.assertEquals(false, streamChecker.query('a'))
		Assert.assertEquals(true, streamChecker.query('b'))
		Assert.assertEquals(true, streamChecker.query('a'))
		Assert.assertEquals(true, streamChecker.query('a'))
		Assert.assertEquals(false, streamChecker.query('a'))
	}

	@Test
	fun `Example 2`() {
		val s = StreamChecker(words = arrayOf("cd", "f", "kl"))
		Assert.assertEquals(false, s.query('a'))
		Assert.assertEquals(false, s.query('b'))
		Assert.assertEquals(false, s.query('c'))
		Assert.assertEquals(true, s.query('d'))
		Assert.assertEquals(false, s.query('e'))
		Assert.assertEquals(true, s.query('f'))
		Assert.assertEquals(false, s.query('g'))
		Assert.assertEquals(false, s.query('h'))
		Assert.assertEquals(false, s.query('i'))
		Assert.assertEquals(false, s.query('j'))
		Assert.assertEquals(false, s.query('k'))
		Assert.assertEquals(true, s.query('l'))
	}
}

