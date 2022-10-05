import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val l1 = ListNode(2).apply {
			next = ListNode(4).apply {
				next = ListNode(3)
			}
		}
		val l2 = ListNode(5).apply {
			next = ListNode(6).apply {
				next = ListNode(4)
			}
		}
		val l3 = Solution().addTwoNumbers(l1, l2)
		val expected = listOf(7, 0, 8)
		Assert.assertEquals(expected, Solution.toArrayList(l3))
	}

	@Test
	fun `Example 2`() {
		val l1 = ListNode(0).apply {
		}
		val l2 = ListNode(0).apply {
		}
		val l3 = Solution().addTwoNumbers(l1, l2)
		val expected = listOf(0)
		Assert.assertEquals(expected, Solution.toArrayList(l3))
	}

	@Test
	fun `Example 3`() {
		val l1 = ListNode(9).apply{ 
			next = ListNode(9).apply{ 
				next = ListNode(9).apply{ 
					next = ListNode(9).apply{ 
						next = ListNode(9).apply{ 
							next = ListNode(9).apply{
								next = ListNode(9)
							}
						}
					}
				}
			}
		}
		
		val l2 = ListNode(9).apply {
			next = ListNode(9).apply{
				next = ListNode(9).apply {
					next = ListNode(9)
				}
			}
		}

		val l3 = Solution().addTwoNumbers(l1, l2)
		val expected = listOf(8,9,9,9,0,0,0,1)
		Assert.assertEquals(expected, Solution.toArrayList(l3))
	}
}

