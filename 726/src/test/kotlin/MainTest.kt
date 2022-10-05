import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val formula = "H2O"
		val expected = "H2O"
		Assert.assertEquals(expected, Solution().countOfAtoms(formula))
	}
	@Test
	fun `Example 2`() {
		val formula = "Mg(OH)2"
		val expected = "H2MgO2"
		Assert.assertEquals(expected, Solution().countOfAtoms(formula))
	}
	@Test
	fun `Example 3`() {
		val formula = "K4(ON(SO3)2)2"
		val expected = "K4N2O14S4"
		Assert.assertEquals(expected, Solution().countOfAtoms(formula))
	}
}

