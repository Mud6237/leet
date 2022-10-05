import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val head = listOf(1,4,3,2,5,2).foldRight<Int, ListNode?>(null, { curr, acc -> ListNode(curr).apply { next = acc } })
		val x = 3
		val expected = listOf(1,2,2,4,3,5)
		Assert.assertEquals(expected, Solution().partition(head, x).toList())
	}

	@Test
	fun `Example 2`() {
		val head = listOf(2,1).foldRight<Int, ListNode?>(null, { curr, acc -> ListNode(curr).apply { next = acc } })
		val x = 2
		val expected = listOf(1, 2)
		Assert.assertEquals(expected, Solution().partition(head, x).toList())
	}
}

