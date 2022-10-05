import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val stockSpanner = StockSpanner()
		Assert.assertEquals(1, stockSpanner.next(100))
		Assert.assertEquals(1, stockSpanner.next(80))
		Assert.assertEquals(1, stockSpanner.next(60))
		Assert.assertEquals(2, stockSpanner.next(70))
		Assert.assertEquals(1, stockSpanner.next(60))
		Assert.assertEquals(4, stockSpanner.next(75))
		Assert.assertEquals(6, stockSpanner.next(85))
	}
}

