import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>"
		val expected = true
		Assert.assertEquals(expected, Solution().isValid(code))
	}

	@Test
	fun `Example 2`() {
		val code = "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"
		val expected = true
		Assert.assertEquals(expected, Solution().isValid(code))
	}

	@Test
	fun `Example 3`() {
		val code = "<A>  <B> </A>   </B>"
		val expected = false
		Assert.assertEquals(expected, Solution().isValid(code))
	}
}

