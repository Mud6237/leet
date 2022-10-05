import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val products = arrayOf("mobile","mouse","moneypot","monitor","mousepad")
		val searchWord = "mouse"
		val expected =  listOf(
			listOf("mobile","moneypot","monitor"),
			listOf("mobile","moneypot","monitor"),
			listOf("mouse","mousepad"),
			listOf("mouse","mousepad"),
			listOf("mouse","mousepad")
		)
		Assert.assertEquals(expected, Solution().suggestedProducts(products, searchWord))
	}
	
	@Test
	fun `Example 2`() {
		val products = arrayOf("havana")
		val searchWord = "havana"
		val expected =  listOf(
			listOf("havana"),
			listOf("havana"),
			listOf("havana"),
			listOf("havana"),
			listOf("havana"),
			listOf("havana")
		)
		Assert.assertEquals(expected, Solution().suggestedProducts(products, searchWord))
	}

	@Test
	fun `Example 3`() {
		val products = arrayOf("bags","baggage","banner","box","cloths")
		val searchWord = "bags"
	 	val expected = listOf(
			listOf("baggage","bags","banner"),
			listOf("baggage","bags","banner"),
			listOf("baggage","bags"),
			listOf("bags")
		)
		Assert.assertEquals(expected, Solution().suggestedProducts(products, searchWord))
	}

	@Test
	fun `Example 4`() {
		val products = arrayOf<String>()
		val searchWord = "abc"
	 	val expected = listOf<List<String>>(emptyList(), emptyList(), emptyList())
		Assert.assertEquals(expected, Solution().suggestedProducts(products, searchWord))
	}

	@Test
	fun `Example 5`() {
		val products = arrayOf<String>("ab")
		val searchWord = "abc"
	 	val expected = listOf<List<String>>(listOf("ab"), listOf("ab"), emptyList())
		Assert.assertEquals(expected, Solution().suggestedProducts(products, searchWord))
	}

}

