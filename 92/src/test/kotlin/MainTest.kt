import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val head = ListNode(1).apply {
			next = ListNode(2).apply {
				next = ListNode(3).apply {
					next = ListNode(4).apply {
						next = ListNode(5)
					}
				}
			}
		}
		val newHead = Solution().reverseBetween(head, 2, 4)
		val expected = listOf(1,4,3,2,5)
		Assert.assertEquals(expected, Solution.toArrayList(newHead))
	}

	@Test
	fun `Example 2`() {
		val head = ListNode(1).apply {
			next = ListNode(2).apply {
				next = ListNode(3).apply {
					next = ListNode(4).apply {
						next = ListNode(5)
					}
				}
			}
		}
		val newHead = Solution().reverseBetween(head, 1, 5)
		val expected = listOf(5, 4, 3, 2, 1)
		Assert.assertEquals(expected, Solution.toArrayList(newHead))
	}

	@Test
	fun `Example 3`() {
		val head = ListNode(1).apply {
			next = ListNode(2).apply {
				next = ListNode(3).apply {
					next = ListNode(4).apply {
						next = ListNode(5)
					}
				}
			}
		}
		val newHead = Solution().reverseBetween(head, 1, 3)
		val expected = listOf(3,2,1,4,5)
		Assert.assertEquals(expected, Solution.toArrayList(newHead))
	}

	@Test
	fun `Example 4`() {
		val head = ListNode(1).apply {
			next = ListNode(2).apply {
				next = ListNode(3).apply {
					next = ListNode(4).apply {
						next = ListNode(5)
					}
				}
			}
		}
		val newHead = Solution().reverseBetween(head, 4, 5)
		val expected = listOf(1,2,3,5,4)
		Assert.assertEquals(expected, Solution.toArrayList(newHead))
	}

	@Test
	fun `Example 5`() {
		val newHead = Solution().reverseBetween(null, 4, 5)
		val expected = listOf<Int>()
		Assert.assertEquals(newHead, null)
		Assert.assertEquals(expected, Solution.toArrayList(newHead))
	}

	@Test
	fun `Example 25`() {
		val newHead = Solution().reverseBetween(ListNode(3).apply{
			next = ListNode(5)
		}, 1, 2)
		val expected = listOf<Int>(5, 3)
		Assert.assertEquals(expected, Solution.toArrayList(newHead))
	}
}

